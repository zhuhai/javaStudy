package com.zhuhai.service.impl;

import com.github.pagehelper.PageHelper;
import com.zhuhai.mapper.UserMapper;
import com.zhuhai.pojo.User;
import com.zhuhai.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Date: 2019/3/23
 * Time: 13:44
 *
 * @author: hai
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Resource
    private UserMapper userMapper;


    @CachePut(value = "user", key = "#user.id")
    @Override
    public User insertUser(User user) {
        log.info("进入insert方法");
        userMapper.insertUser(user);
        return user;
    }

    @Override
    public List<User> listUser() {
        String sql = "select * from sys_user";
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        return userList;
    }

    @Override
    public List<User> findAll() {
        PageHelper.startPage(1,1);
        return userMapper.findAll();
    }

    @Cacheable(value = "user", key = "#id")
    @Override
    public User findById(Long id) {
        log.info("进入get方法");
        return userMapper.findById(id);
    }


}
