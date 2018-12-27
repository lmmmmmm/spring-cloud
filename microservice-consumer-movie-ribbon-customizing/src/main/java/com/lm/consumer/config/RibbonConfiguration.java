package com.lm.consumer.config;

import com.lm.consumer.ExcludeFromComponetScan;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lming.41032@gmail.com
 * @date 18-12-24 下午9:53
 * <p>
 * 配置一个随机规则的负载均衡
 */
@Configuration
@ExcludeFromComponetScan
public class RibbonConfiguration {

    @Autowired
    IClientConfig iClientConfig;

    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }

}
