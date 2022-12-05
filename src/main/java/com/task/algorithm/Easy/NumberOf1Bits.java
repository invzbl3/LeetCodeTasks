package com.task.algorithm.Easy;

/**
 * @author invzbl3 on 12/3/2022
 * @project LeetCodeTask
 */
public class NumberOf1Bits {

    public static int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; ++i) {
            if (((n >>> i) & 1) == 1) {
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int c = -1;
        System.out.println(hammingWeight(c));
    }
}