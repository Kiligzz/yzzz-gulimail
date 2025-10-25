package com.yzzz.gulimall.thirdpart.ossutils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.PutObjectRequest;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;

@Service
public class OSSFileUploadService {

    private final OSS ossClient;
    private final OSSProperties ossProperties;

    // 注入OSS客户端和配置属性
    public OSSFileUploadService(OSS ossClient, OSSProperties ossProperties) {
        this.ossClient = ossClient;
        this.ossProperties = ossProperties;
    }

    public String upload(MultipartFile file, String dir) throws FileUploadException {
        try {
            // 1. 校验文件
            if (file.isEmpty()) {
                throw new FileUploadException("上传文件不能为空");
            }
            // 2. 生成OSS上的唯一文件名（避免重名）
            String originalFilename = file.getOriginalFilename();
            String filename = generateUniqueFilename(originalFilename);
            String ossObjectName = dir + filename; // 完整路径：dir/filename

            // 3. 上传文件（使用输入流）
            try (InputStream inputStream = file.getInputStream()) {
                PutObjectRequest request = new PutObjectRequest(ossProperties.getBucketName(), ossObjectName, inputStream);
                ossClient.putObject(request);
            }

            // 4. 返回文件访问URL
            return generateFileUrl(ossObjectName);

        } catch (Exception e) {
            throw new FileUploadException("文件上传失败：" + e.getMessage(), e);
        }
    }

    public String uploadLocalFile(String localFilePath) throws FileUploadException {
        try {

            if(localFilePath==null || "".equals(localFilePath)){
                throw new RuntimeException("文件路径不能为空:" + localFilePath);
            }

            File file = new File(localFilePath);
            // 1. 校验文件

            // 2. 生成OSS上的唯一文件名（避免重名）

            String ossFileName = generateUniqueFilename(file.getName());

            // 3. 上传文件（使用输入流）

            PutObjectRequest request = new PutObjectRequest(ossProperties.getBucketName(), ossFileName, file);
            ossClient.putObject(request);


            // 4. 返回文件访问URL
            return generateFileUrl(ossFileName);

        } catch (Exception e) {
            throw new FileUploadException("文件上传失败：" + e.getMessage(), e);
        }
    }

    // 生成唯一文件名（时间戳 + 随机数 + 原后缀）
    private String generateUniqueFilename(String originalFilename) {
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        return System.currentTimeMillis() + "_" + RandomUtils.nextInt(10000) + suffix;
    }

    // 生成文件访问URL
    private String generateFileUrl(String ossObjectName) {
        return "https://" + ossProperties.getBucketName() + "." + ossProperties.getEndpoint() + "/" + ossObjectName;
    }
}