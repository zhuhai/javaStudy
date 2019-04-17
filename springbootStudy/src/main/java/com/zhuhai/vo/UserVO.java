package com.zhuhai.vo;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
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
    @NotBlank(message = "用户名不能为空")
    private String userName;

    @Max(value = 150, message = "年龄不能超过150岁")
    @Min(value = 18, message = "未满18岁")
    private Integer age;
    private String sex;
    private Date createTime;
}
