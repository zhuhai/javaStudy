package com.zhuhai.pattern.chain;

/**
 * Created with IntelliJ IDEA
 * Date: 2018/6/21
 * Time: 20:06
 *
 * @author: hai
 */
public class ChainTest {
    public static void main(String[] args) {
        Chain chain = new Chain();
        chain.addHandler(new ChainHandlerA());
        chain.addHandler(new ChainHandlerB());
        chain.process();
    }
}
