package com.zhuhai.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Date: 2018/6/24
 * Time: 19:21
 *
 * @author: hai
 */
public class Combination {

    public void combination(List<Integer> selected, List<Integer> data, int n) {

        if (n == 0) {
            for (Integer i : selected) {
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
            return;
        }

        if (data.isEmpty()) {
            return;
        }

        //选择了第一个元素
        selected.add(data.get(0));
        combination(selected, data.subList(1, data.size()), n-1);
        //不选择第一个元素
        selected.remove(selected.size() - 1);
        combination(selected, data.subList(1, data.size()), n);
        //System.out.println("2222 " + selected.size());
    }

    public static void main(String[] args) {
        Combination combination = new Combination();
        //combination.combination(new ArrayList<>(), Arrays.asList(1, 2, 3, 4), 2);
        combination.combination(new ArrayList<Integer>(), Arrays.asList(1, 2, 3, 4, 5), 3);
    }

}
