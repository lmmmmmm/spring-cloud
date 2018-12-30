package com.lm.consumer.controller;

import com.lm.consumer.user.User;
import com.lm.consumer.user.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lming.41032@gmail.com
 * @date 18-12-21 下午11:08
 */
@RestController
public class MovieController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("user/{id}")
    public User findUserById(@PathVariable("id") String id) {

        User user = userFeignClient.findById(id);
        return user;
    }
}
