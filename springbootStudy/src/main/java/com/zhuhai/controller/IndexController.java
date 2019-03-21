package com.zhuhai.controller;

import com.zhuhai.config.MyConfig2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA
 * Date: 2019/3/17
 * Time: 22:39
 *
 * @author: hai
 */
@Slf4j
@Controller
public class IndexController {

    /*@Autowired
    private MyConfig1 myConfig;*/

    @Autowired
    private MyConfig2 myConfig2;

    @RequestMapping("/")
    public String index(Model model) {

        /*log.info("my name is {}", myConfig.getName());
        log.info("my pwd is {}", myConfig.getPwd());*/
        log.info("my name is {}", myConfig2.getName());
        log.info("my pwd is {}", myConfig2.getPwd());
        log.warn("warn log");
        log.error("error log");
        model.addAttribute("name", myConfig2.getName());
        return "index";
    }

    /*@GetMapping(value = "/user/info")
    public String getUser(Model model) {
        User user = new User();
        user.setUserName("张三");
        user.setAge(26);
        user.setSex("男");
        user.setEmail("123@qq.com");
        model.addAttribute("user", user);
        return "index";
    }

    @GetMapping(value = "/user/list")
    public String listUser(Model model) {
        User user = new User();
        user.setUserName("张三");
        user.setAge(26);
        user.setSex("男");
        user.setEmail("123@qq.com");

        User user2 = new User();
        user2.setUserName("李四");
        user2.setAge(24);
        user2.setSex("男");
        user2.setEmail("lisi@qq.com");

        User user3 = new User();
        user3.setUserName("小仙女");
        user3.setAge(18);
        user3.setSex("女");
        user3.setEmail("test@163.com");

        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user2);
        userList.add(user3);

        model.addAttribute("userList", userList);
        return "index";


    }*/
}
