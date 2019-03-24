package com.zhuhai.service;

import com.zhuhai.pojo.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Date: 2019/3/21
 * Time: 22:35
 *
 * @author: hai
 */
public interface UserService {


    User insertUser(User user);

    List<User> listUser();

    List<User> findAll();

    User findById(Long id);

}
