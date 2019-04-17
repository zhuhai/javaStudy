package com.zhuhai.exception;

import com.zhuhai.vo.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Date: 2019/4/7
 * Time: 21:27
 *
 * @author: hai
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResultBean handler(Exception ex) {
        if (ex instanceof BusinessException) {
            BusinessException businessException = (BusinessException) ex;
            return ResultBean.error(businessException);

        } else if (ex instanceof BindException) {
            BindException bindException = (BindException) ex;
            List<FieldError> fieldErrors = bindException.getFieldErrors();
            List<String> messageList = new ArrayList<>();
            for (FieldError fieldError : fieldErrors) {
                messageList.add(fieldError.getDefaultMessage());
            }
            String message = String.join(",", messageList);
            EnumBusinessError enumBusinessError = EnumBusinessError.PARAMETER_VALIDATION_ERROR;
            enumBusinessError.setMessage(message);
            return ResultBean.error(enumBusinessError);
        }else {
            return ResultBean.error(EnumBusinessError.SYSTEM_ERROR);
        }


    }


}
