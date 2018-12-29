package com.lm.consumer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lming.41032@gmail.com
 * @date 18-12-21 下午11:08
 */
@RestController
public class MovieController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private LoadBalancerClient balancerClient;


    @GetMapping("/log-instance")
    public void logUserInstance() {
        ServiceInstance serviceInstance = balancerClient.choose("provider-user");
        LOGGER.info("{},{},{},{}", serviceInstance.getServiceId(),
                serviceInstance.getHost()
                , serviceInstance.getPort()
                , serviceInstance.getUri()
        );

    }
}
