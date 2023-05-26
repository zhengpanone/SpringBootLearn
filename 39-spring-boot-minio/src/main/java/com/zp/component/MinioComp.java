package com.zp.component;

import com.zp.config.MinioConfiguration;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.PostPolicy;
import io.minio.PutObjectArgs;
import io.minio.errors.*;
import io.minio.http.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class MinioComp {
    @Autowired
    private MinioClient minioClient;
    @Autowired
    private MinioConfiguration configuration;

    /**
     * 获取上传临时签名
     *
     * @param fileName
     * @param time
     * @return
     */
    public Map getPolicy(String fileName, ZonedDateTime time) {
        PostPolicy postPolicy = new PostPolicy(configuration.getBucketName(), time);
        postPolicy.addEqualsCondition("key", fileName);
        try {
            Map<String, String> map = minioClient.getPresignedPostFormData(postPolicy);
            Map<String, String> map1 = new HashMap<>();
            map.forEach((k, v) -> {
                map1.put(k.replaceAll("-", ""), v);
            });
            map1.put("host", configuration.getUrl() + "/" + configuration.getBucketName());
            return map1;
        } catch (ErrorResponseException e) {
            throw new RuntimeException(e);
        } catch (InsufficientDataException e) {
            throw new RuntimeException(e);
        } catch (InternalException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (InvalidResponseException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (ServerException e) {
            throw new RuntimeException(e);
        } catch (XmlParserException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取上传临时签名
     *
     * @param objectName
     * @param method
     * @param time
     * @param timeUnit
     * @return
     */
    public String getPolicyUrl(String objectName, Method method, int time, TimeUnit timeUnit) {
        try {
            return minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs
                    .builder()
                    .method(method).bucket(configuration.getBucketName())
                    .object(objectName).expiry(time, timeUnit).build());
        } catch (ErrorResponseException e) {
            throw new RuntimeException(e);
        } catch (InsufficientDataException e) {
            throw new RuntimeException(e);
        } catch (InternalException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (InvalidResponseException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (XmlParserException e) {
            throw new RuntimeException(e);
        } catch (ServerException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 上传文件
     *
     * @param file
     * @param fileName
     */
    public void upload(MultipartFile file, String fileName) {
        try {
            InputStream inputStream = file.getInputStream();
            minioClient.putObject(PutObjectArgs.builder()
                    .bucket(configuration.getBucketName())
                    .object(fileName)
                    .stream(inputStream, file.getSize(), -1)
                    .contentType(file.getContentType())
                    .build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ServerException e) {
            throw new RuntimeException(e);
        } catch (InsufficientDataException e) {
            throw new RuntimeException(e);
        } catch (ErrorResponseException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (InvalidResponseException e) {
            throw new RuntimeException(e);
        } catch (XmlParserException e) {
            throw new RuntimeException(e);
        } catch (InternalException e) {
            throw new RuntimeException(e);
        }

    }

    public String getUrl(String objectName, int time, TimeUnit timeUnit) {
        String url = null;
        try {
            url = minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder()
                    .method(Method.GET)
                    .bucket(configuration.getBucketName())
                    .object(objectName)
                    .expiry(time, timeUnit)
                    .build());
        } catch (ErrorResponseException e) {
            throw new RuntimeException(e);
        } catch (InsufficientDataException e) {
            throw new RuntimeException(e);
        } catch (InternalException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (InvalidResponseException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (XmlParserException e) {
            throw new RuntimeException(e);
        } catch (ServerException e) {
            throw new RuntimeException(e);
        }
        return url;
    }
}
