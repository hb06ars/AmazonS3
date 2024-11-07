package org.example;

import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.CreateBucketRequest;
import software.amazon.awssdk.services.s3.model.CreateBucketResponse;
public class Bucket {

    public static void createBucket(S3Client s3, String bucketName) {
        CreateBucketRequest createBucketRequest = CreateBucketRequest.builder()
                .bucket(bucketName)
                .build();

        CreateBucketResponse createBucketResponse = s3.createBucket(createBucketRequest);
        System.out.println("Bucket criado com sucesso: " + createBucketResponse.location());
    }

}
