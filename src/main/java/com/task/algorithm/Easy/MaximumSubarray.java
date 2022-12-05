package com.task.algorithm.Easy;

/**
 * @author invzbl3 on 12/3/2022
 * @project LeetCodeTask
 */

/*
    Algorithm description:
    ---------------------
    Subarrays are arrays inside another array which only contains contiguous elements.

    Given an array of integers, the task is to find the maximum subarray sum possible
    of all the non-empty subarrays.

    Example:

    Input: [-3, -4, 5, -1, 2, -4, 6, -1]
    Output: 8
    Explanation: Subarray [5, -1, 2, -4, 6] is the max sum contiguous subarray with sum 8.

    Input: [-2, 3, -1, 2]
    Output: 4
    Explanation: Subarray [3, -1, 2] is the max sum contiguous subarray with sum 4.

    We would be solving the problem by following approaches –

    - Simple approach
    - Efficient Approach: Kadane’s Algorithm


    Simple Approach:

    The simple approach to solve this problem is to run two for loops and for every subarray check if
    it is the maximum sum possible. Follow the below steps to solve the problem.

    Run a loop for i from 0 to n – 1, where n is the size of the array.
    Now, we will run a nested loop for j from i to n – 1 and add the value of the element at index j
    to a variable currentMax. Lastly, for every subarray, we will check if the currentMax is the
    maximum sum of all contiguous subarrays.
 */

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
// https://www.baeldung.com/java-maximum-subarray
// https://www.interviewbit.com/blog/maximum-subarray-sum/
class MaximumSubarray {

    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
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