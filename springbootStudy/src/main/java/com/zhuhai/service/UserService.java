package com.zhuhai.service;

import com.zhuhai.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Date: 2019/3/21
 * Time: 22:35
 *
 * @author: hai
 */
@Service
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> listUser() {
        String sql = "select * from sys_user";
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        return userList;
    }
}
