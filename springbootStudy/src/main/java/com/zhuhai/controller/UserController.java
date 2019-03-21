package com.zhuhai.controller;

import com.zhuhai.entity.User;
import com.zhuhai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Date: 2019/3/21
 * Time: 22:34
 *
 * @author: hai
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public String listUser(Model model) {
        List<User> userList = userService.listUser();
        model.addAttribute("userList", userList);
        return "user";
    }
}
