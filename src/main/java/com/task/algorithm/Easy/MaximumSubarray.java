package com.task.algorithm.Easy;

// Easy
// Given an integer array nums,
// find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

// A subarray is a contiguous part of an array.

// Example 1:
// Input:
// nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output:
// 6

// Explanation:
// [4,-1,2,1] has the largest sum = 6.

// Example 2:
// Input:
// nums = [1]
// Output:
// 1

// Example 3:
// Input:
// nums = [5,4,-1,7,8]
// Output:
// 23

// Constraints:
// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104

// Follow up:
// If you have figured out the O(n) solution,
// try coding another solution using the divide and conquer approach,
// which is more subtle.

// Solution 1

/**
 * @author invzbl3 on 12/3/2022
 * @project LeetCodeTask
 */
// Solution 1
class MaximumSubarray {

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }

    public static int maxSubArray(int[] nums) {
        int glbMax = nums[0];
        int presum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (presum < 0) {
                presum = nums[i];
            } else {
                presum += nums[i];
            }
            glbMax = Math.max(glbMax, presum);
        }

        return glbMax;
    }
}
// TC: O(n); SC: O(1)
// Success
// Details
// Runtime: 2 ms, faster than 58.57% of Java online submissions for Maximum Subarray.
// Memory Usage: 74.9 MB, less than 26.33% of Java online submissions for Maximum Subarray.

// Solution 2
/*class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE, temp = 0;
        for (int num : nums) {
            temp = Math.max(temp + num, num);
            res = Math.max(temp, res);
        }
        return res;
    }
}*/
// TC: O(n); SC: O(1)
// Success
// Details
// Runtime: 2 ms, faster than 58.57% of Java online submissions for Maximum Subarray.
// Memory Usage: 75.2 MB, less than 23.65% of Java online submissions for Maximum Subarray.