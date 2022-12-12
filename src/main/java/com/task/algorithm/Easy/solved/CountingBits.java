package com.task.algorithm.Easy.solved;

import java.util.Arrays;

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