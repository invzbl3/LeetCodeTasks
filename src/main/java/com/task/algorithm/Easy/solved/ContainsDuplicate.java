package com.task.algorithm.Easy.solved;

import java.util.HashSet;

/**
 * 217. Contains Duplicate
 * https://leetcode.com/problems/contains-duplicate/
 *
 * Given an integer array nums, return true if any value appears at least twice in the array, and
 * return false if every element is distinct.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: true
 *
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: false
 *
 * Example 3:
 *
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 */

// https://cheonhyangzhang.gitbooks.io/leetcode-solutions/content/217-contains-duplicate-easy.html
// https://www.gyanblog.com/coding-interview/leetcode-solution-find-array-contains-duplicate/
// https://medium.com/@saurav.agg19/contains-duplicate-e360989d3d65
public class ContainsDuplicate {

    /*    public class Solution {
        public boolean containsDuplicate(int[] nums) {
            HashSet<Integer> set = new HashSet<Integer>();
            for (int i = 0; i < nums.length; i ++){
                if (set.contains(nums[i])){
                    return true;
                }
                set.add(nums[i]);
            }
            return false;
        }
    }*/

    public static void main(String[] args) {
        int[] array = {2, 1, 5, 4, 2, 3, 1}; // true
        System.out.println(containsDuplicate(array));

        array = new int[]{2, 1, 3, 0}; // false
        System.out.println(containsDuplicate(array));

        array = new int[]{1, 2, 3, 1}; // true
        System.out.println(containsDuplicate(array));

        array = new int[]{1, 2, 3, 4}; // false
        System.out.println(containsDuplicate(array));

        array = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}; // true
        System.out.println(containsDuplicate(array));
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }
}