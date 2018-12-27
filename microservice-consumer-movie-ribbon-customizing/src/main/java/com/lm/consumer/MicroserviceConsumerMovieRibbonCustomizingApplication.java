package com.lm.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

/**
 * 配置ribbon负载均衡:
 * see {@link com.lm.consumer.config.TestRibbonConfiguration}
 * <p>
 * 注意:{@link com.lm.consumer.config.RibbonConfiguration} 不能被被component扫描到,
 * 否则该类的所有配置信息就会被所有的@RibbonClient共享
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeFromComponetScan.class)})
public class MicroserviceConsumerMovieRibbonCustomizingApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceConsumerMovieRibbonCustomizingApplication.class, args);
    }

}

