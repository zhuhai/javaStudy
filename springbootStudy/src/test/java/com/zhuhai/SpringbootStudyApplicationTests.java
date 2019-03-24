package com.zhuhai;

import com.github.pagehelper.PageHelper;
import com.zhuhai.mapper.SysUserMapper;
import com.zhuhai.mapper.UserMapper;
import com.zhuhai.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringbootStudyApplicationTests {

    @Resource
    private UserMapper userMapper;
    @Resource
    private SysUserMapper sysUserMapper;

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

}
