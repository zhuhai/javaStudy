package com.zhuhai.pattern.strategy;

import com.zhuhai.pattern.strategy.impl.FlyNoWay;

/**
 * Created with IntelliJ IDEA
 * Date: 2018/10/5
 * Time: 22:01
 *
 * @author: hai
 */
public class RubberDuck extends Duck {

    public RubberDuck() {
        super();
        super.setFlyingStragety(new FlyNoWay());
    }

    @Override
    public void quack() {
        System.out.println("嘎~嘎~嘎~");
    }

    @Override
    public void display() {
        System.out.println("我是一只橡皮鸭");
    }
}
