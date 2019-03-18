package com.zhuhai.pattern.strategy;

import com.zhuhai.pattern.strategy.impl.FlyWithWin;

/**
 * Created with IntelliJ IDEA
 * Date: 2018/10/5
 * Time: 21:50
 *
 * @author: hai
 */
public class ReadHeadDuck extends Duck {

    public ReadHeadDuck() {
        super();
        super.setFlyingStragety(new FlyWithWin());
    }

    @Override
    public void display() {
        System.out.println("我的头是红色的");
    }
}
