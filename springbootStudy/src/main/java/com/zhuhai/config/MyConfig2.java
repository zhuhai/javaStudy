package com.zhuhai.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA
 * Date: 2019/3/17
 * Time: 23:25
 *
 * @author: hai
 */
@Component
public class MyConfig2 {

    @Value("${admin.name}")
    private String name;

    @Value("${admin.pwd}")
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
