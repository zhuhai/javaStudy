package com.zhuhai.vo;

import com.zhuhai.exception.CommonError;
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
        resultBean.setCode(1);
        resultBean.setMessage("success");
        return resultBean;
    }

    public static ResultBean success(Object data) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(1);
        resultBean.setMessage("success");
        resultBean.setData(data);

        return resultBean;
    }

    public static ResultBean error(CommonError commonError) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(commonError.getCode());
        resultBean.setMessage(commonError.getMessage());
        return resultBean;

    }


}
