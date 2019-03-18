package com.zhuhai.interview.linkedList.loop;


import com.zhuhai.interview.linkedList.LinkedListCreator;
import com.zhuhai.interview.linkedList.Node;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * Date: 2018/6/24
 * Time: 21:03
 *
 * @author: hai
 */
public class LinkedListReverser {

    public Node reverseLinkedList(Node head) {
        //指向已经反转的
        Node newHead = null;
        //指向未反转的
        Node curHead = head;
        while (curHead != null) {
            Node next = curHead.getNext();
            curHead.setNext(newHead);
            newHead = curHead;
            curHead = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        LinkedListCreator linkedListCreator = new LinkedListCreator();
        LinkedListReverser linkedListReverser = new LinkedListReverser();
        Node.print(linkedListReverser.reverseLinkedList(linkedListCreator.createLinkedList(new ArrayList<Integer>())));
        Node.print(linkedListReverser.reverseLinkedList(linkedListCreator.createLinkedList(Arrays.asList(1))));
        Node.print(linkedListReverser.reverseLinkedList(linkedListCreator.createLinkedList(Arrays.asList(1,2,3,4,5))));
    }

}
