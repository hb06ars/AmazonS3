package org.example;

import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

import java.nio.file.Paths;

public class Upload {

    public static void uploadFile(S3Client s3, String bucketName, String key, String filePath) {
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(key)  // O nome do arquivo no S3
                .build();

        PutObjectResponse putObjectResponse = s3.putObject(putObjectRequest, Paths.get(filePath));
        System.out.println("Arquivo enviado para o S3: " + putObjectResponse.eTag());
    }


}
