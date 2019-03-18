package com.zhuhai.interview.linkedList;

/**
 * Created with IntelliJ IDEA
 * Date: 2018/6/24
 * Time: 15:40
 *
 * @author: hai
 */
public class Node {

    private final int value;
    private Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }


    public Integer getValue() {
        return value;
    }


    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.getValue());
            System.out.print(" ");
            head = head.getNext();
        }
        System.out.println("");
    }
}
