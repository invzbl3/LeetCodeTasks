package com.task.algorithm.Medium.solved;

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