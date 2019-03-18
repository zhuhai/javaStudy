package com.zhuhai.interview.linkedList;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * Date: 2018/6/24
 * Time: 16:24
 *
 * @author: hai
 */
public class Test {

    public static void main(String[] args) {

        /*LinkedListCreator linkedListCreator = new LinkedListCreator();
        Node.print(linkedListCreator.createLinkedList(new ArrayList<Integer>()));
        Node.print(linkedListCreator.createLinkedList(Arrays.asList(1)));
        Node.print(linkedListCreator.createLinkedList(Arrays.asList(1,2,3,4,5)));*/

        LinkedListCreator linkedListCreator = new LinkedListCreator();
        LinkedListReverser linkedListReverser = new LinkedListReverser();
        Node.print(linkedListReverser.reverseLinkedList(linkedListCreator.createLinkedList(new ArrayList<Integer>())));
        Node.print(linkedListReverser.reverseLinkedList(linkedListCreator.createLinkedList(Arrays.asList(1))));
        Node.print(linkedListReverser.reverseLinkedList(linkedListCreator.createLinkedList(Arrays.asList(1,2,3,4,5))));

    }
}
