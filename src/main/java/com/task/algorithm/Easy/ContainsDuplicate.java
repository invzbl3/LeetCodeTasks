package com.task.algorithm.Easy;

import java.util.HashSet;

/**
 * @author invzbl3 on 12/3/2022
 * @project LeetCodeTask
 */

/*
    Algorithm description:
    ---------------------
    Given an array of integers, find if the array contains any duplicates.

    Your function should return true if any value appears at least twice in the array,
    and it should return false if every element is distinct.
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