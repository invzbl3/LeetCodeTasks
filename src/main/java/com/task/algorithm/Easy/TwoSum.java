package com.task.algorithm.Easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author invzbl3 on 12/3/2022
 * @project LeetCodeTask
 */
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