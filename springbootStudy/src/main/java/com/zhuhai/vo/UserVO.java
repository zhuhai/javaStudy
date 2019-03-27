package com.zhuhai.vo;

import lombok.Data;

import java.util.Date;

/**
 * Created with IntelliJ IDEA
 * Date: 2019/3/23
 * Time: 16:00
 *
 * @author: hai
 */
@Data
public class UserVO {

    private Integer id;
    private String userName;
    private Integer age;
    private String sex;
    private Date createTime;
}
