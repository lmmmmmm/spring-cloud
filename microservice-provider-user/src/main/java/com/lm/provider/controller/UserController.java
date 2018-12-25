package com.lm.provider.controller;

import com.lm.provider.user.User;
import com.lm.provider.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lming.41032@gmail.com
 * @date 18-12-21 下午5:49
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("user/{id}")
    public User findById(@PathVariable("id") String id) {
        User user = userMapper.selectById(id);
        return user;
    }
}
