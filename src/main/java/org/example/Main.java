package org.example;

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

import static org.example.Bucket.createBucket;
import static org.example.Download.downloadFile;
import static org.example.Listar.listObjects;
import static org.example.Upload.uploadFile;

public class Main {
    public static void main(String[] args) {
        // Criar o cliente S3 usando o perfil configurado no arquivo .aws/credentials
        S3Client s3 = S3Client.builder()
                .credentialsProvider(ProfileCredentialsProvider.create())  // Usa o perfil padrão
                .region(Region.US_EAST_1)  // Defina a região desejada
                .build();

        // Nome do Bucket
        String bucketName = "meu-bucket-uniquename";

        // Criar o bucket (diretório)
        createBucket(s3, bucketName);

        // Fazer upload de um arquivo
        String filePath = "C:\\Users\\nomeDoUser\\OneDrive\\Desktop\\texto_teste.txt";
        String key = "file.txt";  // Nome do arquivo no S3
        uploadFile(s3, bucketName, key, filePath);

        // Listar os objetos do bucket
        listObjects(s3, bucketName);

        // Fazer o download do arquivo
        String downloadPath = "C:\\Users\\nomeDoUser\\OneDrive\\Desktop\\downloadtexto.txt";
        downloadFile(s3, bucketName, key, downloadPath);

        // Fechar o cliente
        s3.close();
    }

    // Métodos de operações (criar bucket, upload, download, listar objetos) seguem o exemplo anterior...
}
