package com.task.algorithm.Hard.solved;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 85. Maximal Rectangle
 * https://leetcode.com/problems/maximal-rectangle/
 *
 * Given a rows x cols binary matrix filled with 0's and 1's,
 * find the largest rectangle containing only 1's and return its area.
 *
 * Example 1:
 *
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 6
 * Explanation: The maximal rectangle is shown in the above picture.
 *
 * Example 2:
 *
 * Input: matrix = [["0"]]
 * Output: 0
 *
 * Example 3:
 *
 * Input: matrix = [["1"]]
 * Output: 1
 *
 * Constraints:
 *
 * * rows == matrix.length
 * * cols == matrix[i].length
 * * 1 <= row, cols <= 200
 * * matrix[i][j] is '0' or '1'.
 */
public class MaximalRectangle {

    public static void main(String[] args) {
        MaximalRectangle sol = new MaximalRectangle();
        System.out.println(sol.maximalRectangle(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        })); // 6
        System.out.println(sol.maximalRectangle(new char[][]{{}})); // 0
        System.out.println(sol.maximalRectangle(new char[][]{{'0'}})); // 0
        System.out.println(sol.maximalRectangle(new char[][]{{'1'}})); // 1
        System.out.println(sol.maximalRectangle(new char[][]{{'0', '0'}})); // 0
        System.out.println(sol.maximalRectangle(new char[][]{
                {'0', '0', '1'},
                {'1', '1', '1'}
        })); // 3
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int n = matrix[0].length;

        int max = 0;
        int[] dp = new int[n];
        for (char[] row : matrix) {
            if (row.length == 0) break;
            for (int j = 0; j < n; j++) {
                if (row[j] == '0') {
                    dp[j] = 0;
                } else {
                    dp[j] += 1;
                }
            }
            // System.out.println("dp = " + Arrays.toString(dp));
            max = Math.max(max, maxRect0(dp));
        }
        return max;
    }

    private int maxRect0(int[] dp) {
        // System.out.println("dp = " + Arrays.toString(dp));
        int n = dp.length;
        Deque<Integer> deq = new ArrayDeque<>(n);
        int max = 0;
        for (int i = 0; i < n; i++) {
            // System.out.println("deq = " + deq);
            while (!deq.isEmpty() && dp[i] < dp[deq.getLast()]) {
                int idx = deq.removeLast();
                int w = deq.isEmpty() ? i : i - deq.getLast() - 1;
                max = Math.max(max, w * dp[idx]);
            }
            deq.addLast(i);
            // System.out.println("max = " + max);
        }
        while (!deq.isEmpty()) {
            // System.out.println("deq = " + deq);
            int idx = deq.removeLast();
            int w = deq.isEmpty() ? n : n - deq.getLast() - 1;
            max = Math.max(max, w * dp[idx]);
            // System.out.println("max = " + max);
        }
        return max;
    }
}