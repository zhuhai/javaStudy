package com.zhuhai.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
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
@JsonInclude(Include.NON_NULL)
public class UserVO {

    private Integer id;
    private String userName;
    private Integer age;
    private String sex;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date createTime;
}
