package com.lm.consumer.controller;

import com.lm.consumer.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author lming.41032@gmail.com
 * @date 18-12-21 下午11:08
 */
@RestController
public class MovieController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private RestTemplate template;

    @Autowired
    private LoadBalancerClient balancerClient;


    @GetMapping("user/{id}")
    public User findUserById(@PathVariable("id") String id) {
        User user = template.getForObject("http://MICROSERVICE-PROVIDER-USER/user/" + id, User.class);
        return user;
    }

    /**
     * 错误演示:
     * <p>
     * 不能将restTemplate.getForObject(...)与loadBalancerClient.choose()方法写在
     * 同一个方法中,两者之间会有冲突,因为此时restTemplate已经是Ribbon客户端,包含的choose方法.
     *
     * @param id
     * @return
     */
    @GetMapping("user/id/{id}")
    public User test(@PathVariable("id") String id) {
        ServiceInstance serviceInstance = balancerClient.choose("microservice-provider-user");
        final String url = serviceInstance.getUri() + "/user/" + id;
        User user = template.getForObject(url, User.class);
        return user;
    }

    @GetMapping("/log-instance")
    public void logUserInstance() {
        ServiceInstance serviceInstance = balancerClient.choose("microservice-provider-user");
        LOGGER.info("{},{},{},{}", serviceInstance.getServiceId(),
                serviceInstance.getHost()
                , serviceInstance.getPort()
                , serviceInstance.getUri()
        );

    }
}
