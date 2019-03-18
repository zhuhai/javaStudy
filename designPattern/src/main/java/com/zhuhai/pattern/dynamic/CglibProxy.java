package com.zhuhai.pattern.dynamic;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA
 * Date: 2018/6/7
 * Time: 21:22
 *
 * @author: hai
 */
public class CglibProxy implements MethodInterceptor {


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib开始。。。");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("cglib结束。。。");
        return result;
    }
}
