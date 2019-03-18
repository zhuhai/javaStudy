package com.zhuhai.pattern.chain2;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Date: 2018/6/21
 * Time: 20:16
 *
 * @author: hai
 */
public class Chain {

    private List<ChainHandler> chainHandlers;
    private int index = 0;

    public Chain(List<ChainHandler> chainHandlers) {
        this.chainHandlers = chainHandlers;
    }

    public void proceed() {
        if (index >= chainHandlers.size()) {
            return;
        }
        chainHandlers.get(index++).execute(this);
    }

}
