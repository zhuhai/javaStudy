package com.zhuhai.pattern.strategy.impl;

import com.zhuhai.pattern.strategy.FlyingStragety;

/**
 * Created with IntelliJ IDEA
 * Date: 2018/10/5
 * Time: 22:02
 *
 * @author: hai
 */
public class FlyNoWay implements FlyingStragety {

    @Override
    public void performFly() {
        System.out.println("我不会飞呀");
    }
}
