package com.zhuhai.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA
 * Date: 2019/3/19
 * Time: 22:59
 *
 * @author: hai
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -1178553933645696036L;

    private Integer id;
    private String userName;
    private Integer age;
    private String sex;
    private String email;
    private String password;
    private Date createTime;

}
