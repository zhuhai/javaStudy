package com.zhuhai.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created with IntelliJ IDEA
 * Date: 2019/3/19
 * Time: 22:59
 *
 * @author: hai
 */
@Data
public class User {
    private Integer id;
    private String userName;
    private Integer age;
    private String sex;
    private String email;
    private String password;
    private Date createTime;

}
