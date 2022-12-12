package com.task.algorithm.Medium.solved;

import java.util.*;

// Medium

// Given an m x n matrix, return all elements of the matrix in spiral order.

// Example 1:

// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [1,2,3,6,9,8,7,4,5]

// Example 2:
// Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
// Output: [1,2,3,4,8,12,11,10,9,5,6,7]

// Constraints:
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 10
// -100 <= matrix[i][j] <= 100

// Java program for the above approach
class SpiralMatrix {

    // Function to print in spiral order
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        if (matrix.length == 0)
            return ans;

        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] seen = new boolean[m][n];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int x = 0;
        int y = 0;
        int di = 0;

        // Iterate from 0 to R * C - 1
        for (int i = 0; i < m * n; i++) {
            ans.add(matrix[x][y]);
            seen[x][y] = true;
            int cr = x + dr[di];
            int cc = y + dc[di];

            if (0 <= cr && cr < m && 0 <= cc && cc < n
                    && !seen[cr][cc]) {
                x = cr;
                y = cc;
            } else {
                di = (di + 1) % 4;
                x += dr[di];
                y += dc[di];
            }
        }
        return ans;
    }

    // Driver Code
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        // Function call
        System.out.println(spiralOrder(a));
    }
}