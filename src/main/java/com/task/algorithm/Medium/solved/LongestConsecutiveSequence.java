package com.task.algorithm.Medium.solved;

import java.util.HashSet;

/*
 * 128. Longest Consecutive Sequence
 *
 * Given an unsorted array of integers nums, return
 * the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 * Example 1:
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 *
 * Explanation: The longest
 * consecutive elements sequence is
 * [1, 2, 3, 4]. Therefore, it's length
 * is 4.
 *
 * Example 2:
 *
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 *
 * Constraints:
 *
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 */
public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(longestConsecutive(arr));
    }

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int result = 0;

        for (int num : nums) {
            int count = 1;

            int down = num - 1;
            while (set.contains(down)) {
                set.remove(down);
                down--;
                count++;
            }

            int up = num + 1;
            while (set.contains(up)) {
                set.remove(up);
                up++;
                count++;
            }

            result = Math.max(result, count);
        }

        return result;
    }
}