package com.lm.consumer;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lming.41032@gmail.com
 * @date 18-12-24 下午9:53
 */
@Configuration
public class RibbonConfiguration {

    @Bean
    public IRule ribbonRule(IClientConfig config) {
        return new RandomRule();
    }
}
