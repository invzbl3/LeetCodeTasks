package com.task.algorithm.Medium;

import java.util.Arrays;

/**
 * @author invzbl3 on 12/3/2022
 * @project LeetCodeTask
 */
public class ProductOfArrayExceptSelf {

    /**
     * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
     * <p>
     * Example:
     * <p>
     * Input:  [1,2,3,4]
     * Output: [24,12,8,6]
     * Note: Please solve it without division and in O(n).
     * <p>
     * Follow up:
     * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    static int[] productExceptSelf(int[] nums) {
        int temp = 1;
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        // left product
        for (int i = 0; i < result.length; i++) {
            result[i] = temp;
            temp *= nums[i];
        }
        // right product
        temp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= temp;
            temp *= nums[i];
        }
        return result;
    }
}