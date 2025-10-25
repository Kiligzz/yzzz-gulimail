package com.yzzz.gulimall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@MapperScan("com.yzzz.gulimall.product.dao")
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.yzzz" // OSSFileUploadServiceImpl 所在的包
})
@ConfigurationPropertiesScan(basePackages = {"com.yzzz.common.config"})
public class GulimallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallProductApplication.class, args);
    }

}
