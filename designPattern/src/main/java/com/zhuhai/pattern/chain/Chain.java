package com.zhuhai.pattern.chain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Date: 2018/6/21
 * Time: 20:03
 *
 * @author: hai
 */
public class Chain {

    private List<ChainHandler> chainHandlers = new ArrayList<>();

    public void addHandler(ChainHandler chainHandler) {
        chainHandlers.add(chainHandler);
    }

    public void process() {
        for (ChainHandler chainHandler : chainHandlers) {
            chainHandler.execute();
        }
    }
}
