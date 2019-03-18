package com.zhuhai.pattern.chain2;

/**
 * Created with IntelliJ IDEA
 * Date: 2018/6/21
 * Time: 20:16
 *
 * @author: hai
 */
public abstract class ChainHandler {

    public void execute(Chain chain) {
        handlerProcess();
        chain.proceed();

    }

    protected abstract void handlerProcess();
}
