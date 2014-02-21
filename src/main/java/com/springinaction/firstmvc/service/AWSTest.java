package com.springinaction.firstmvc.service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.*;
import com.google.common.io.ByteSource;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Random;

public class AWSTest {
    public static void main(String... args) throws IOException {
        ByteSource pictureSource = getSamplePictureSource();
        try (InputStream pictureStream = pictureSource.openStream()) {
            AmazonS3 s3 = new AmazonS3Client(new ClasspathPropertiesFileCredentialsProvider());
            System.out.println("List of buckets:");
            for (Bucket bucket : s3.listBuckets()) {
                System.out.println(" - " + bucket.getName());
            }

            s3.putObject(new PutObjectRequest("phonecatalog", "testTextFile", createSampleFile()));
            s3.putObject(new PutObjectRequest("phonecatalog", "testPicture",
                    pictureStream,
                    getSamplePictureObjectMetadata(pictureSource)));

            System.out.println("1st List of objects:");
            ObjectListing objectListing = s3.listObjects(new ListObjectsRequest().withBucketName("phonecatalog"));
            for (S3ObjectSummary objectSummary : objectListing.getObjectSummaries()) {
                System.out.println(" - " + objectSummary.getKey() + "  " +
                        "(size = " + objectSummary.getSize() + ")");
            }
            s3.deleteObjects(new DeleteObjectsRequest("phonecatalog").withKeys("testPicture", "testTextFile"));

            System.out.println("2nd List of objects:");
            objectListing = s3.listObjects(new ListObjectsRequest().withBucketName("phonecatalog"));
            for (S3ObjectSummary objectSummary : objectListing.getObjectSummaries()) {
                System.out.println(" - " + objectSummary.getKey() + "  " +
                        "(size = " + objectSummary.getSize() + ")");
            }
        } catch (AmazonServiceException ase) {
            System.out.println("Caught an AmazonServiceException, which means your request made it "
                    + "to Amazon S3, but was rejected with an error response for some reason.");
            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            System.out.println("Caught an AmazonClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with S3, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message: " + ace.getMessage());
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

    private static ObjectMetadata getSamplePictureObjectMetadata(ByteSource pictureSource) throws IOException {
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(pictureSource.size());
        metadata.setContentType("image/jpeg");
        return metadata;
    }
}
