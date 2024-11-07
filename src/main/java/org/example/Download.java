package org.example;

import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import java.nio.file.Paths;

public class Download {

    public static void downloadFile(S3Client s3, String bucketName, String key, String downloadPath) {
        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build();

        GetObjectResponse getObjectResponse = s3.getObject(getObjectRequest, Paths.get(downloadPath));
        System.out.println("Arquivo baixado do S3: " + getObjectResponse);
    }



}
