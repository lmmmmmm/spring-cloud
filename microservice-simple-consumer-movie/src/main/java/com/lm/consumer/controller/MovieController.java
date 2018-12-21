package com.lm.consumer.controller;

import com.lm.consumer.user.User;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private RestTemplate template;


    @GetMapping("user/{id}")
    public User findUserById(@PathVariable("id") String id) {
        final String ip = "http://localhost:8080/user/";
        User user = template.getForObject(ip + id, User.class);
        return user;
    }
}
