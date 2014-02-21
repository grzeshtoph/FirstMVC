package com.springinaction.firstmvc.service;

import com.google.common.io.ByteSource;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;
import org.jets3t.service.S3Service;
import org.jets3t.service.S3ServiceException;
import org.jets3t.service.impl.rest.httpclient.RestS3Service;
import org.jets3t.service.model.S3Bucket;
import org.jets3t.service.security.AWSCredentials;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Random;

public class Jets3tTest {
    private static final String ACCESS_KEY = "<put value here>";
    private static final String SECRET_KEY = "<put value here>";

    public static void main(String... args) throws IOException {
        ByteSource pictureSource = getSamplePictureSource();
        try (InputStream pictureStream = pictureSource.openStream()) {
            AWSCredentials awsCredentials = new AWSCredentials(ACCESS_KEY, SECRET_KEY);
            S3Service s3Service = new RestS3Service(awsCredentials);
            System.out.println("List of buckets:");
            for (S3Bucket bucket : s3Service.listAllBuckets()) {
                System.out.println(" - " + bucket.getName());
            }

//            s3.putObject(new PutObjectRequest("phonecatalog", "testTextFile", createSampleFile()));
//            s3.putObject(new PutObjectRequest("phonecatalog", "testPicture",
//                    pictureStream,
//                    getSamplePictureObjectMetadata(pictureSource)));
//
//            System.out.println("1st List of objects:");
//            ObjectListing objectListing = s3.listObjects(new ListObjectsRequest().withBucketName("phonecatalog"));
//            for (S3ObjectSummary objectSummary : objectListing.getObjectSummaries()) {
//                System.out.println(" - " + objectSummary.getKey() + "  " +
//                        "(size = " + objectSummary.getSize() + ")");
//            }
//            s3.deleteObjects(new DeleteObjectsRequest("phonecatalog").withKeys("testPicture", "testTextFile"));
//
//            System.out.println("2nd List of objects:");
//            objectListing = s3.listObjects(new ListObjectsRequest().withBucketName("phonecatalog"));
//            for (S3ObjectSummary objectSummary : objectListing.getObjectSummaries()) {
//                System.out.println(" - " + objectSummary.getKey() + "  " +
//                        "(size = " + objectSummary.getSize() + ")");
//            }
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

    private static ByteSource getSamplePictureSource() {
        String[] pictures = new String[]{"C:\\Users\\Public\\Pictures\\Sample Pictures\\Chrysanthemum.jpg",
                "C:\\Users\\Public\\Pictures\\Sample Pictures\\Jellyfish.jpg"};

        return Files.asByteSource(new File(pictures[new Random().nextInt(2)]));
    }
//
//    private static ObjectMetadata getSamplePictureObjectMetadata(ByteSource pictureSource) throws IOException {
//        ObjectMetadata metadata = new ObjectMetadata();
//        metadata.setContentLength(pictureSource.size());
//        metadata.setContentType("image/jpeg");
//        return metadata;
//    }
}
