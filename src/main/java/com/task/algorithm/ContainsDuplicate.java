package com.task.algorithm;

import java.util.HashSet;

/**
 * @author invzbl3 on 12/3/2022
 * @project LeetCodeTask
 */

// https://cheonhyangzhang.gitbooks.io/leetcode-solutions/content/217-contains-duplicate-easy.html
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
        int[] numbers = {2, 7, 11, 15};
        //int target = 9;

        System.out.println((containsDuplicate(numbers)));
    }

    public static boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length == 0)
            return false;

        HashSet<Integer> set = new HashSet<>();
        for(int i : nums){
            if(!set.add(i)){
                return true;
            }
        }
        return false;
    }
}