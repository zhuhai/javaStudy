package com.zhuhai.mapper;

import com.zhuhai.entity.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Date: 2019/3/23
 * Time: 13:30
 *
 * @author: hai
 */
public interface UserMapper {

    int insertUser(User user);

    List<User> findAll();

    User findById(Long id);

}
