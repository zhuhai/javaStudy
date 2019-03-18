package com.zhuhai.pattern.strategy.impl;

import com.zhuhai.pattern.strategy.FlyingStragety;

/**
 * Created with IntelliJ IDEA
 * Date: 2018/10/5
 * Time: 21:54
 *
 * @author: hai
 */
public class FlyWithWin implements FlyingStragety {
    @Override
    public void performFly() {
        System.out.println("振翅高飞");
    }
}
