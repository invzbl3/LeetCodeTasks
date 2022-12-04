package com.task.algorithm.Medium;

import java.util.Arrays;

/**
 * @author invzbl3 on 12/3/2022
 * @project LeetCodeTask
 */
// https://leetcode.com/problems/counting-bits/
public class CountingBits {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2)));
        System.out.println(Arrays.toString(countBits(5)));
    }

    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];

        ans[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                ans[i] = ans[i / 2];
            } else {
                ans[i] = ans[i - 1] + 1;
            }
        }
        return ans;
    }
}