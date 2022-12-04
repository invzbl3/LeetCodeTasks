package com.task.algorithm;

import java.util.Arrays;

/**
 * @author invzbl3 on 12/3/2022
 * @project LeetCodeTask
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        int[] arr = {-3, 1, -8, 4, -1, 2, 1, -5, 5};

        System.out.println(Arrays.toString(arr));
    }

    public static int maxSubArraySum(int[] arr) {

        int size = arr.length;
        int start = 0;
        int end = 0;

        int maxSoFar = arr[0], maxEndingHere = arr[0];

        for (int i = 1; i < size; i++) {
            if (arr[i] > maxEndingHere + arr[i]) {
                start = i;
                maxEndingHere = arr[i];
            } else
                maxEndingHere = maxEndingHere + arr[i];

            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
                end = i;
            }
        }
        return maxSoFar;
    }
}