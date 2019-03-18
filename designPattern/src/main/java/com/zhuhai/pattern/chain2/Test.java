package com.zhuhai.pattern.chain2;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Date: 2018/6/21
 * Time: 20:21
 *
 * @author: hai
 */
public class Test {

    public static class ChainHandlerA extends ChainHandler {

        @Override
        protected void handlerProcess() {
            System.out.println("A process");
        }
    }
    public static class ChainHandlerB extends ChainHandler {

        @Override
        protected void handlerProcess() {
            System.out.println("B process");
        }
    }

    public static void main(String[] args) {
        List<ChainHandler> chainHandlers = Arrays.asList(new ChainHandlerA(), new ChainHandlerB());
        Chain chain = new Chain(chainHandlers);
        chain.proceed();
    }

}
