package com.zhuhai.pattern.dynamic;

import net.sf.cglib.proxy.Enhancer;

/**
 * Created with IntelliJ IDEA
 * Date: 2018/6/5
 * Time: 22:27
 *
 * @author: hai
 */
public class Test {

    public static void main(String[] args) {

       /* Car car = new Car();
        TimeHandler timeHandler = new TimeHandler(car);
        Class<?> clazz = car.getClass();

        Moveable moveable = (Moveable) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), timeHandler);
        moveable.move();*/

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Car.class);
        enhancer.setCallback(new CglibProxy());
        Moveable moveable = (Moveable) enhancer.create();
        moveable.move();
        System.out.println(moveable.getClass().getSuperclass());

    }
}
