package com.zhuhai.exception;

/**
 * Created with IntelliJ IDEA
 * Date: 2019/4/7
 * Time: 21:10
 *
 * @author: hai
 */
public interface CommonError {

    public int getCode();
    public String getMessage();
    public CommonError setMessage(String message);
}
