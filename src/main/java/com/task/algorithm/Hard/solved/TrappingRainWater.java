package com.task.algorithm.Hard.solved;

/**
 * 42. Trapping Rain Water
 * https://leetcode.com/problems/trapping-rain-water/
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 *
 * Example 1:
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by
 * array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water
 * (blue section) are being trapped.
 *
 * Example 2:
 *
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 *
 * Constraints:
 *
 * * n == height.length
 * * 1 <= n <= 2 * 10^4
 * * 0 <= height[i] <= 10^5
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        if (height.length < 2) return 0;
        int ans = 0;
        int size = height.length;
        int[] left = new int[size];
        int[] right = new int[size];

        left[0] = height[0];

        for (int i = 1; i < size; i++) {
            left[i] = Math.max(height[i], left[i - 1]);
        }

        right[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            right[i] = Math.max(height[i], right[i + 1]);
        }

        for (int i = 0; i < size; i++) {
            ans = ans + Math.min(left[i], right[i]) - height[i];
        }
        return ans;
    }
}