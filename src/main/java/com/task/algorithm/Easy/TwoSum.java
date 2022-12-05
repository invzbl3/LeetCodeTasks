package com.task.algorithm.Easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author invzbl3 on 12/3/2022
 * @project LeetCodeTask
 */

/*
    Algorithm description:
    ---------------------
    Given an array of integers, return the indices of the two numbers whose sum is equal to a given target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    Example:

    Given nums = [2, 7, 11, 15], target = 9.

    The output should be [0, 1].
    Because nums[0] + nums[1] = 2 + 7 = 9.
 */

// https://www.callicoder.com/two-sum-problem/
public class TwoSum {

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }

    public static int[] twoSum(int[] numbers, int target) {

        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {

            Integer diff = target - numbers[i];
            if (hash.containsKey(diff)) {
                return new int[]{hash.get(diff) + 1, i + 1};
            }
            hash.put(numbers[i], i);
        }
        return new int[0];
    }
}