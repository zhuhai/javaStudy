package com.zhuhai.pattern.chain;

/**
 * Created with IntelliJ IDEA
 * Date: 2018/6/21
 * Time: 20:06
 *
 * @author: hai
 */
public class ChainHandlerB implements ChainHandler {

    @Override
    public void execute() {
        System.out.println("B execute");
    }
}
