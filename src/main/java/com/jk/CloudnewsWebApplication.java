package com.jk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EnableDiscoveryClient//去注册中心注册
@EnableFeignClients//可以调用服务中心的项目
@MapperScan("com.jk.mapper")
public class CloudnewsWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudnewsWebApplication.class, args);
    }

}
