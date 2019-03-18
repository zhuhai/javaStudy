package com.zhuhai.interview.linkedList;

/**
 * Created with IntelliJ IDEA
 * Date: 2018/6/24
 * Time: 16:54
 *
 * @author: hai
 */
public class LinkedListReverser {

    public Node reverseLinkedList(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        //先反转第一个节点后面的节点
        Node newHead = reverseLinkedList(head.getNext());
        //反转后的节点指向第一个节点
        head.getNext().setNext(head);
        //第一个节点指向null
        head.setNext(null);
        return newHead;
    }
}
