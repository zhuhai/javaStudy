package com.zhuhai;
import com.github.pagehelper.PageHelper;
import com.zhuhai.mapper.SysUserMapper;
import com.zhuhai.mapper.UserMapper;
import com.zhuhai.pojo.User;
import com.zhuhai.service.UserService;
import com.zhuhai.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringbootStudyApplicationTests {

    @Resource
    private UserMapper userMapper;
    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private RedisTemplate<String, Serializable> redisCacheTemplate;

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private UserService userService;

    @Test
    public void test1() {
        User user = userService.findById(1L);
        log.info("user is {}", user);
        Assert.assertNotNull(user);
    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUserName("王五");
        user.setPassword("123456");
        user.setCreateTime(new Date());
        userService.insertUser(user);
        log.info("保存的user id为：{}", user.getId());
    }

    @Test
    public void testPageUser() {
        PageHelper.startPage(1,1).setOrderBy("id desc");
        List<User> userList = userMapper.findAll();
        for (User user : userList) {
            System.out.println(user.toString());
        }
        /*List<SysUser> sysUserList = sysUserMapper.selectAll();
        for (SysUser sysUser : sysUserList) {
            System.out.println(sysUser.getUsername());
        }*/
    }

    @Test
    public void testRedis() {
        //stringRedisTemplate.opsForValue().set("stringRedisKey", "stringRedisValue");
        //redisCacheTemplate.opsForValue().set("stringRedisKey2", "stringRedisValue2");
        //String value = (String) redisCacheTemplate.opsForValue().get("stringRedisKey2");
        /*User user = new User();
        user.setId(1);
        user.setUserName("张三");
        user.setAge(26);*/
        //redisCacheTemplate.opsForValue().set("user", user);
        //User value = (User)redisCacheTemplate.opsForValue().get("user");
        //System.out.println(value.toString());

        /*for (int i = 0; i < 1000; i++) {
            //stringRedisTemplate.opsForValue().increment("incrTest");
            redisCacheTemplate.opsForValue().increment("incrTest2");
        }*/
        //redisUtil.sadd("testSet", "aa","bb");
        /*User user = new User();
        user.setId(1);
        user.setUserName("张三");
        user.setAge(20);
        user.setSex("男");
        user.setEmail("zhangsan@163.com");
        user.setPassword("123456");
        user.setCreateTime(new Date());
        redisUtil.sadd("user", user);*/
        /*Set<User> users = redisUtil.smembers("user");
        for (User user : users) {
            System.out.println(user);
        }*/
        redisUtil.zadd("test", "test", 12.2);
        redisUtil.zadd("test", "test2", 11.0);
        redisUtil.zadd("test", "test3", 13.5);
        redisUtil.zadd("test", "test4", 10);


    }

}
