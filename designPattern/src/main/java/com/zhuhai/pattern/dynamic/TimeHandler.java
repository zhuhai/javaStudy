package com.zhuhai.pattern.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA
 * Date: 2018/6/5
 * Time: 22:15
 *
 * @author: hai
 */
public class TimeHandler implements InvocationHandler {

    private Object target;

    public TimeHandler(Object target) {
        //super();
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        long startTime = System.currentTimeMillis();
        System.out.println("汽车开始行驶。。。。");
        Object result = method.invoke(target);
        long endTime = System.currentTimeMillis();
        System.out.println("汽车停止行驶。。。行驶时间：" + (endTime-startTime) + "毫秒");

        return result;
    }
}
