package com.zhuhai.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA
 * Date: 2019/3/17
 * Time: 22:49
 *
 * @author: hai
 */
@Component
@ConfigurationProperties(prefix = "admin")
public class MyConfig1 {

    private String name;
    private String pwd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
