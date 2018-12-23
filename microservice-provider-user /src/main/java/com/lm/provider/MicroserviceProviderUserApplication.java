package com.lm.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.lm.**.mapper")
@EnableDiscoveryClient
public class MicroserviceProviderUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceProviderUserApplication.class, args);
    }

}

