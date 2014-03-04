package com.springinaction.firstmvc.service;

import com.google.common.io.ByteSource;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;
import org.jets3t.service.S3Service;
import org.jets3t.service.S3ServiceException;
import org.jets3t.service.impl.rest.httpclient.RestS3Service;
import org.jets3t.service.model.S3Bucket;
import org.jets3t.service.model.S3Object;
import org.jets3t.service.security.AWSCredentials;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Random;

public class Jets3tTest {
    private static final String OBJECT_ID_PREFIX = Jets3tTest.class.getSimpleName() + "_";
    private static final String PICTURE_FILE_ID = OBJECT_ID_PREFIX + "testPicture";
    private static final String THUMBNAIL_FILE_ID = OBJECT_ID_PREFIX + "testPictureThumbnail";
    private static final String TEXT_FILE_ID = OBJECT_ID_PREFIX + "testTextFile";
    private static final String ACCESS_KEY = "";
    private static final String SECRET_KEY = "";

    public static void main(String... args) throws IOException {
        File samplePicture = getSamplePicture();
        ByteSource pictureSource = Files.asByteSource(samplePicture);
        ByteSource thumbnailSource = Files.asByteSource(getSamplePictureThumbnail(samplePicture));

        try (InputStream pictureStream = pictureSource.openStream();
             InputStream thumbnailStream = thumbnailSource.openStream()) {
            AWSCredentials awsCredentials = new AWSCredentials(ACCESS_KEY, SECRET_KEY);
            S3Service s3Service = new RestS3Service(awsCredentials);

            System.out.println("List of buckets:");
            S3Bucket[] buckets = s3Service.listAllBuckets();
            for (S3Bucket bucket : buckets) {
                System.out.println(" - " + bucket.getName());
            }

            S3Bucket bucket = s3Service.getBucket("phonecatalog");
            s3Service.deleteMultipleObjects(bucket.getName(), new String[]{PICTURE_FILE_ID, TEXT_FILE_ID});

            S3Object textFileObject = new S3Object(TEXT_FILE_ID);
            File sampleFile = createSampleFile();
            textFileObject.setDataInputFile(sampleFile);
            textFileObject.setContentLength(sampleFile.length());
            textFileObject.setContentType("text/plain");

            S3Object testPictureObject = new S3Object(PICTURE_FILE_ID);
            testPictureObject.setDataInputStream(pictureStream);
            testPictureObject.setContentLength(pictureSource.size());
            testPictureObject.setContentType("image/jpeg");

            S3Object testThumbnailObject = new S3Object(THUMBNAIL_FILE_ID);
            testThumbnailObject.setDataInputStream(thumbnailStream);
            testThumbnailObject.setContentLength(thumbnailSource.size());
            testThumbnailObject.setContentType("image/jpeg");

            s3Service.putObject(bucket, textFileObject);
            s3Service.putObject(bucket, testPictureObject);
            s3Service.putObject(bucket, testThumbnailObject);

            System.out.println("1st List of objects:");
            for (S3Bucket bucket1 : buckets) {
                System.out.println("  - bucket " + bucket1.getName());
                for (S3Object object : s3Service.listObjects(bucket1.getName())) {
                    System.out.println("    - " + object.getKey() + " (" + object.getContentLength() + "B)");
                }
            }
        } catch (S3ServiceException e) {
            System.out.println("Caught an S3ServiceException, which means your request made it "
                    + "to Amazon S3, but was rejected with an error response for some reason.");
            System.out.println("Error Message:  " + e.getMessage());
            System.out.println("Error Code:     " + e.getS3ErrorCode());
            System.out.println("Error Host ID:  " + e.getS3ErrorHostId());
            System.out.println("Request ID:     " + e.getS3ErrorRequestId());
        }
    }

    /**
     * Creates a temporary file with text data to demonstrate uploading a file
     * to Amazon S3
     *
     * @return A newly created temporary file with text data.
     * @throws IOException
     */

    private static File createSampleFile() throws IOException {
        File file = File.createTempFile("aws-java-sdk-", ".txt");
        file.deleteOnExit();

        try (Writer writer = Files.asCharSink(file, Charset.forName("UTF-8"), FileWriteMode.APPEND).openStream()) {
            writer.write("abcdefghijklmnopqrstuvwxyz\n");
            writer.write("01234567890112345678901234\n");
            writer.write("!@#$%^&*()-=[]{};':',.<>/?\n");
            writer.write("01234567890112345678901234\n");
            writer.write("abcdefghijklmnopqrstuvwxyz\n");
        }

        return file;
    }

    private static File getSamplePicture() {
        String[] pictures = new String[]{"C:\\Users\\Public\\Pictures\\Sample Pictures\\Chrysanthemum.jpg",
                "C:\\Users\\Public\\Pictures\\Sample Pictures\\Jellyfish.jpg"};

        return new File(pictures[new Random().nextInt(2)]);
    }

    private static File getSamplePictureThumbnail(File inputFile) throws IOException {
        File tmpFile = File.createTempFile(OBJECT_ID_PREFIX, ".jpg");
        tmpFile.deleteOnExit();
        return ThumbnailatorTest.makeThumbnailOf(inputFile, tmpFile);
    }
}
