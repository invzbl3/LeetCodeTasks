package com.task.algorithm.Hard.solved;

/**
 * 41. First Missing Positive
 * https://leetcode.com/problems/first-missing-positive/
 *
 * Given an unsorted integer array nums, return the smallest missing positive integer.
 * You must implement an algorithm that runs in O(n) time and uses constant extra space.
 *
 * Example 1:
 *
 * Input: nums = [1,2,0]
 * Output: 3
 * Explanation: The numbers in the range [1,2] are all in the array.
 *
 * Example 2:
 *
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * Explanation: 1 is in the array but 2 is missing.
 *
 * Example 3:
 *
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 * Explanation: The smallest positive integer 1 is missing.
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^5
 * -2^31 <= nums[i] <= 2^31 - 1
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int pos = nums[i];
            while (pos - 1 >= 0 && pos - 1 < nums.length && nums[pos - 1] != pos) {
                int nextPos = nums[pos - 1];
                nums[pos - 1] = pos;
                pos = nextPos;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public int firstMissingPositiveWRONG2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = nums.length + 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                int j = nums[i];
                while (j > 0 && j <= nums.length) {
                    int tmp = nums[j - 1];
                    nums[j - 1] = 500;
                    j = tmp;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 500) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public int firstMissingPositive1(int[] nums) {
        int[] rst = new int[nums.length];
        for (int i : nums) {
            if (i <= nums.length && i > 0) {
                rst[i - 1] = 1;
            }
        }
        for (int i = 0; i < rst.length; i++) {
            if (rst[i] == 0) {
                return i + 1;
            }
        }
        return rst.length + 1;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 0};
        System.out.println(new FirstMissingPositive().firstMissingPositive(nums));

        nums = new int[]{-5};
        System.out.println(new FirstMissingPositive().firstMissingPositive(nums));

        nums = new int[]{2, 1};
        System.out.println(new FirstMissingPositive().firstMissingPositive(nums));

        nums = new int[]{1};
        System.out.println(new FirstMissingPositive().firstMissingPositive(nums));

        nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(new FirstMissingPositive().firstMissingPositive(nums));

        nums = new int[]{3, 4, -1, 1};
        System.out.println(new FirstMissingPositive().firstMissingPositive(nums));

        nums = new int[]{7, 8, 9, 11, 12};
        System.out.println(new FirstMissingPositive().firstMissingPositive(nums));

        // nums = new int[]{1,2,0};
        // System.out.println(new FirstMissingPositive().firstMissingPositive(nums));
    }
}