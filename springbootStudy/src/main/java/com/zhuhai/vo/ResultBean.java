package com.zhuhai.vo;

import com.zhuhai.exception.CommonError;
import com.zhuhai.exception.EnumBusinessError;
import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA
 * Date: 2019/4/7
 * Time: 21:25
 *
 * @author: hai
 */
@Data
public class ResultBean implements Serializable {
    private static final long serialVersionUID = 845973225568553599L;

    private int code;
    private String message;
    private Object data;


    public static ResultBean success() {
        ResultBean resultBean = new ResultBean();
        resultBean.setResultCode(EnumBusinessError.SUCCESS);
        return resultBean;
    }

    public static ResultBean success(Object data) {
        ResultBean resultBean = new ResultBean();
        resultBean.setResultCode(EnumBusinessError.SUCCESS);
        resultBean.setData(data);

        return resultBean;
    }

    public static ResultBean error(CommonError commonError) {
        ResultBean resultBean = new ResultBean();
        resultBean.setResultCode(commonError);
        return resultBean;

    }

    private void setResultCode(CommonError commonError) {
        this.code = commonError.getCode();
        this.message = commonError.getMessage();
    }


}
