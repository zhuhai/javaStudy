package com.zhuhai.pattern.strategy;

/**
 * Created with IntelliJ IDEA
 * Date: 2018/10/5
 * Time: 21:46
 *
 * @author: hai
 */
public abstract class Duck {

    private FlyingStragety flyingStragety;

    public void quack() {
        System.out.println("嘎嘎嘎~");
    }

    public abstract void display();

    public void setFlyingStragety(FlyingStragety flyingStragety) {
        this.flyingStragety = flyingStragety;
    }

    public void fly() {
        flyingStragety.performFly();
    }
}
