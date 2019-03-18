package com.zhuhai.pattern.dynamic;

import java.util.Random;

/**
 * Created with IntelliJ IDEA
 * Date: 2018/6/5
 * Time: 22:24
 *
 * @author: hai
 */
public class Car implements Moveable {

    @Override
    public void move() {

        try {
            Thread.sleep(new Random().nextInt(1000));
            System.out.println("汽车行驶中。。。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
