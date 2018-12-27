package com.lm.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * eureka 伪集群配置
 * 1.修改系统host文件:localhost peer1 pee2
 * 2:mvn install
 * 3:java -jar xxxxx.jar --spring.profiles.active=peer1
 * 4:java -jar xxxxx.jar --spring.profiles.active=peer2
 */
@SpringBootApplication
@EnableEurekaServer
public class MicroserviceDiscoveryEurekaHaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceDiscoveryEurekaHaApplication.class, args);
    }

}

