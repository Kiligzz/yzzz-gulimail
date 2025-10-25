package com.yzzz.gulimall.thirdpart.ossutils;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
//@Component
@ConfigurationProperties(prefix = "aliyun.oss") // 对应配置文件的前缀
public class OSSProperties {
    private String endpoint;         // OSS地域端点（如oss-cn-beijing.aliyuncs.com）
    private String accessKeyId;      // 阿里云accessKeyId
    private String accessKeySecret;  // 阿里云accessKeySecret
    private String bucketName;       // OSS Bucket名称

    @PostConstruct
    public void debugConfig() {
        System.out.println("===== OSS配置绑定结果 =====");
        System.out.println("endpoint: " + endpoint); // 看是否为null
        System.out.println("accessKeyId: " + accessKeyId);
        System.out.println("accessKeySecret: " + accessKeySecret);
        System.out.println("bucketName: " + bucketName);
        System.out.println("===========================");
    }
    // getter + setter（必须有，否则无法绑定配置）
}