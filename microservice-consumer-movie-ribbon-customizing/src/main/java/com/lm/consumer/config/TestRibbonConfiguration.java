package com.lm.consumer.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

/**
 * @author lming.41032@gmail.com
 * @date 18-12-24 下午9:59
 */
@Configuration
@RibbonClient(name = "microservice.provider-user", configuration = RibbonConfiguration.class)
public class TestRibbonConfiguration {

}
