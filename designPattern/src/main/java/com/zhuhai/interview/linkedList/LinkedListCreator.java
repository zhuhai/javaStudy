package com.zhuhai.interview.linkedList;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Date: 2018/6/24
 * Time: 16:16
 *
 * @author: hai
 */
public class LinkedListCreator {

    public Node createLinkedList(List<Integer> values) {
        if (values.isEmpty()) {
            return null;
        }
        //生成链表第一个节点
        Node firstNode = new Node(values.get(0));
        //递归生成剩余的节点
        Node headOfSubList = createLinkedList(values.subList(1, values.size()));
        firstNode.setNext(headOfSubList);
        return firstNode;
    }


}
