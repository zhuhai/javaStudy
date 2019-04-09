package com.zhuhai.exception;

import com.zhuhai.vo.ResultBean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created with IntelliJ IDEA
 * Date: 2019/4/7
 * Time: 21:27
 *
 * @author: hai
 */
@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResultBean handler(Exception ex) {
        if (ex instanceof BusinessException) {
            BusinessException businessException = (BusinessException) ex;
            return ResultBean.error(businessException);

        } else {
            return ResultBean.error(EnumBusinessError.SYSTEM_ERROR);
        }


    }


}
