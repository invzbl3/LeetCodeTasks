package com.task.algorithm.Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author invzbl3 on 12/4/2022
 * @project LeetCodeTask
 */

/*
    Algorithm description:
    ---------------------

    // ...
 */
public class FindMedianFromDataStream {

    /*public static void main(String[] args) {
        System.out.println();
    }*/

    class MedianFinder {
        List<Integer> input = new ArrayList<>();
        public void addNum(int num) {
            input.add(num);
        }

        public double findMedian() {
            Collections.sort(input);
            int len = input.size();
            if (len % 2 == 1) return input.get(len / 2);
            return 0.5 * (input.get(len / 2) + input.get(len / 2 - 1));
        }
    }
}