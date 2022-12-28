package com.task.algorithm.Medium.solved;

/**
 * 152. Maximum Product Subarray
 * https://leetcode.com/problems/maximum-product-subarray/
 *
 * Given an integer array nums, find a subarray that has the largest product, and return the product.
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 *
 * Example 1:
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 *
 * Example 2:
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 * Constraints:
 * 1 <= nums.length <= 2 * 10^4
 * -10 <= nums[i] <= 10
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 */

// Java program to find maximum product subarray
class MaximumProductSubarray {
    /* Returns the product of max product subarray.*/
    static int maxProduct(int[] nums) {
        // Initializing result
        int result = nums[0];
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int mul = nums[i];
            // traversing in current subarray
            for (int j = i + 1; j < n; j++) {
                // updating result every time to keep an eye
                // over the maximum product
                result = Math.max(result, mul);
                mul *= nums[j];
            }
            // updating the result for (n-1)th index.
            result = Math.max(result, mul);
        }
        return result;
    }

    // Driver Code
    public static void main(String[] args) {
        int[] arr = {1, -2, -3, 0, 7, -8, -2};
        System.out.println("Maximum Sub array product is "
                + maxProduct(arr));
    }
}