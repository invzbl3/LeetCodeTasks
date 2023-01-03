package com.task.algorithm.Hard.solved;

import java.util.Stack;

/**
 * 84. Largest Rectangle in Histogram
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 *
 * Given an array of integers heights representing the histogram's bar height
 * where the width of each bar is 1, return the area of the largest rectangle
 * in the histogram.
 *
 * Example 1:
 *
 * Input: heights = [2,1,5,6,2,3]
 * Output: 10
 * Explanation: The above is a histogram where width of each bar is 1.
 * The largest rectangle is shown in the red area, which has an area = 10 units.
 *
 * Example 2:
 *
 * Input: heights = [2,4]
 * Output: 4
 *
 * Constraints:
 * * 1 <= heights.length <= 10^5
 * * 0 <= heights[i] <= 10^4
 */
class LargestRectangleInHistogram {

    public int maxSquare2(int[] nums) {
        int max = 0;
        int m = 0;
        int low = 0;
        for (int i = 0; i < nums.length; i++) {
            m = nums[i];
            low = nums[i];
            for (int j = i - 1; j >= 0 && nums[j] > 0; j--) {
                low = Math.min(low, nums[j]);
                int t = (i - j + 1) * low;
                if (m < t) {
                    m = t;
                }
            }
            if (max < m) {
                max = m;
            }
        }
        return max;
    }

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length < 1) {
            return 0;
        }

        Stack<Integer> incStack = new Stack<>();
        int popIndex;
        int maxRange;
        int max = heights[0];
        incStack.push(0);

        int i = 1;
        while (!incStack.isEmpty()) {
            while ((i < heights.length && heights[incStack.peek()] > heights[i]) || i == heights.length) {
                popIndex = incStack.pop();
                if (heights[popIndex] > 0) {
                    maxRange = incStack.isEmpty() ? i : (i - incStack.peek() - 1);
                    max = Math.max(max, heights[popIndex] * maxRange);
                }
                if (incStack.isEmpty()) {
                    break;
                }
            }
            if (i < heights.length) {
                incStack.push(i++);
            }
        }
        return max;
    }
}