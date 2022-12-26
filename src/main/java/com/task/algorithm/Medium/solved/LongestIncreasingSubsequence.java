package com.task.algorithm.Medium.solved;

/**
 * 300. Longest Increasing Subsequence
 * https://leetcode.com/problems/longest-increasing-subsequence/
 *
 * Given an integer array nums, return the length of the longest strictly increasing
 * subsequence.
 *
 * Example 1:
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 *
 * Example 2:
 *
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 *
 * Example 3:
 *
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2500
 * -10^4 <= nums[i] <= 10^4
 *
 * Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence lengthOfLIS = new LongestIncreasingSubsequence();
        System.out.println(6 == lengthOfLIS.lengthOfLIS(new int[]{3,5,6,2,5,4,19,5,6,7,12}));
        System.out.println(6 == lengthOfLIS.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
        System.out.println(3 == lengthOfLIS.lengthOfLIS(new int[]{4,10,4,3,8,9}));
        System.out.println(1 == lengthOfLIS.lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
        System.out.println(4 == lengthOfLIS.lengthOfLIS(new int[]{0,1,0,3,2,3}));
        System.out.println(4 == lengthOfLIS.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}