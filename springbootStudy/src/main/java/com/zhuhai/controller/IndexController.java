package com.zhuhai.controller;

import com.zhuhai.config.MyConfig2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA
 * Date: 2019/3/17
 * Time: 22:39
 *
 * @author: hai
 */
@Slf4j
@RestController
public class IndexController {

    /*@Autowired
    private MyConfig1 myConfig;*/

    @Autowired
    private MyConfig2 myConfig2;

    @RequestMapping("/")
    public String index() {

        /*log.info("my name is {}", myConfig.getName());
        log.info("my pwd is {}", myConfig.getPwd());*/
        log.info("my name is {}", myConfig2.getName());
        log.info("my pwd is {}", myConfig2.getPwd());

        return "hello springBoot!";
    }
}
