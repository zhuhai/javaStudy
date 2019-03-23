package com.zhuhai.service.impl;

import com.zhuhai.entity.User;
import com.zhuhai.mapper.UserMapper;
import com.zhuhai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Resource
    private UserMapper userMapper;

    @Override
    public User insertUser(User user) {
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
        return userMapper.findAll();
    }

    @Override
    public User findById(Long id) {
        return userMapper.findById(id);
    }
}
