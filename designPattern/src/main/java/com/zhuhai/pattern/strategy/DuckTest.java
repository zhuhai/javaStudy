package com.zhuhai.pattern.strategy;

/**
 * Created with IntelliJ IDEA
 * Date: 2018/10/5
 * Time: 21:52
 *
 * @author: hai
 */
public class DuckTest {

    public static void main(String[] args) {

        //Duck duck = new MallardDuck();
        //Duck duck = new ReadHeadDuck();
        Duck duck = new RubberDuck();
        duck.quack();
        duck.display();
        duck.fly();


    }
}
