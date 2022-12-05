package com.task.algorithm.Hard;

import java.util.HashSet;

/**
 * @author invzbl3 on 12/4/2022
 * @project LeetCodeTask
 */
public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(longestConsecutive(arr));
    }

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums) set.add(num);

        int result = 0;

        for(int num: nums){
            int count = 1;

            int down = num-1;
            while(set.contains(down)){
                set.remove(down);
                down--;
                count++;
            }

            int up = num+1;
            while(set.contains(up)){
                set.remove(up);
                up++;
                count++;
            }

            result = Math.max(result, count);
        }

        return result;
    }
}