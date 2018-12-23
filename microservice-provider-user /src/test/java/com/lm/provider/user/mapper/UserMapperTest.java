package com.lm.provider.user.mapper;

import com.lm.provider.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.*;

/**
 * @author lming.41032@gmail.com
 * @date 18-12-21 下午10:27
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectById() {
        User user = userMapper.selectById("admin");
        assertNotNull(user);
    }
}