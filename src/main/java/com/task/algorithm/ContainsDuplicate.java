package com.task.algorithm;

import java.util.HashSet;

/**
 * @author invzbl3 on 12/3/2022
 * @project LeetCodeTask
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;

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