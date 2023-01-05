package com.task.algorithm.Medium.solved;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 18. 4Sum
 * https://leetcode.com/problems/4sum/
 *
 * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b],
 * nums[c], nums[d]] such that:
 *
 * * 0 <= a, b, c, d < n
 * * a, b, c, and d are distinct.
 * * nums[a] + nums[b] + nums[c] + nums[d] == target
 *
 * You may return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 *
 * Example 2:
 *
 * Input: nums = [2,2,2,2,2], target = 8
 * Output: [[2,2,2,2]]
 *
 * Constraints:
 *
 * * 1 <= nums.length <= 200
 * * -10^9 <= nums[i] <= 10^9
 * * -10^9 <= target <= 10^9
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        int lens = nums.length;
        for (int i = 0; i < lens - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            if (nums[i] + nums[lens - 1] + nums[lens - 2] + nums[lens - 3] < target) continue;

            for (int j = i + 1; j < lens - 2; j++) {
                if (j - i > 1 && nums[j] == nums[j - 1]) continue;

                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                if (nums[i] + nums[j] + nums[lens - 1] + nums[lens - 2] < target) continue;

                int left = j + 1;
                int right = lens - 1;
                while (left < right) {
                    int temp = nums[i] + nums[j] + nums[left] + nums[right];
                    if (temp > target)
                        right--;
                    else if (temp < target)
                        left++;
                    else {
                        List<Integer> temList = new LinkedList<>(
                                Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        res.add(temList);
                        while (left < right && nums[left] == nums[left + 1])
                            left++;
                        while (left < right && nums[right] == nums[right - 1])
                            right--;
                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }
}