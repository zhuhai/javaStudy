package com.zhuhai;

import com.zhuhai.entity.User;
import com.zhuhai.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringbootStudyApplicationTests {

    @Resource
    private UserMapper userMapper;


    @Test
    public void test1() {
        User user = userMapper.findById(1L);
        log.info("user is {}", user);
        Assert.assertNotNull(user);
    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUserName("王五3");
        user.setPassword("123456");
        userMapper.insertUser(user);
        log.info("保存的user id为：{}", user.getId());
    }

}
