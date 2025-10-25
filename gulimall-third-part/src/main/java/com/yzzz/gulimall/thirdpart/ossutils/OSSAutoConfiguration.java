package com.yzzz.gulimall.thirdpart.ossutils;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 包路径：com.example.common.oss.config
@Configuration
@EnableConfigurationProperties(OSSProperties.class) // 启用配置属性绑定
public class OSSAutoConfiguration {

    private final OSSProperties ossProperties;

    // 构造器注入配置属性
    public OSSAutoConfiguration(OSSProperties ossProperties) {
        this.ossProperties = ossProperties;
    }

    // 定义OSS客户端Bean（由Spring管理，业务模块直接注入使用）
    @Bean
    @ConditionalOnMissingBean // 允许业务模块自定义OSS客户端（覆盖默认）
    public OSS ossClient() {
        // 校验配置是否完整
        validateProperties();
        // 创建并返回OSS客户端
        return new OSSClientBuilder().build(
                ossProperties.getEndpoint(),
                ossProperties.getAccessKeyId(),
                ossProperties.getAccessKeySecret()
        );
    }

    // 校验配置参数，避免空指针
    private void validateProperties() {
        if (StringUtils.isEmpty(ossProperties.getEndpoint())
                || StringUtils.isEmpty(ossProperties.getAccessKeyId())
                || StringUtils.isEmpty(ossProperties.getAccessKeySecret())
                || StringUtils.isEmpty(ossProperties.getBucketName())) {
            throw new IllegalArgumentException("阿里云OSS配置不完整，请检查application.yml" + ossProperties);
        }
    }
}