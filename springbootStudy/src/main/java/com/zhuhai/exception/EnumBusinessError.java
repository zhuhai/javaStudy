package com.zhuhai.exception;

/**
 * Created with IntelliJ IDEA
 * Date: 2019/4/7
 * Time: 21:19
 *
 * @author: hai
 */
public enum EnumBusinessError implements CommonError {
    PARAMETER_VALIDATION_ERROR(10000, "参数不合法"),
    SYSTEM_ERROR(99999, "未知错误"),
    USER_NOT_EXIST(10001, "用户不存在");



    private int code;
    private String message;

    EnumBusinessError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public CommonError setMessage(String message) {
        this.message = message;
        return this;
    }
}
