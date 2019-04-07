package com.zhuhai.exception;

/**
 * Created with IntelliJ IDEA
 * Date: 2019/4/7
 * Time: 21:14
 *
 * @author: hai
 */
public class BusinessException extends RuntimeException implements CommonError{


    private CommonError commonError;

    public BusinessException(CommonError commonError) {
        super();
        this.commonError = commonError;
    }

    public BusinessException(CommonError commonError, String message) {
        super();
        this.commonError = commonError;
        commonError.setMessage(message);
    }


    @Override
    public int getCode() {
        return this.commonError.getCode();
    }

    @Override
    public String getMessage() {
        return this.commonError.getMessage();
    }

    @Override
    public CommonError setMessage(String message) {
        this.commonError.setMessage(message);
        return this;
    }
}
