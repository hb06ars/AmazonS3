package org.example;

import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Request;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Response;

public class Listar {

    public static void listObjects(S3Client s3, String bucketName) {
        ListObjectsV2Request listObjectsRequest = ListObjectsV2Request.builder()
                .bucket(bucketName)
                .build();

        ListObjectsV2Response listObjectsResponse = s3.listObjectsV2(listObjectsRequest);
        listObjectsResponse.contents().forEach(s3Object -> {
            System.out.println("Objeto: " + s3Object.key());
        });
    }


}
