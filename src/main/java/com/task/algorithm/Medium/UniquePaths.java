package com.task.algorithm.Medium;

/**
 * @author invzbl3 on 12/3/2022
 * @project LeetCodeTask
 */
public class UniquePaths {
    static int UniquePathHelper(int i, int j, int r, int c,
                                int[][] A) {
        // boundary condition or constraints
        if (i == r || j == c) {
            return 0;
        }

        if (A[i][j] == 1) {
            return 0;
        }

        // base case
        if (i == r - 1 && j == c - 1) {
            return 1;
        }

        return UniquePathHelper(i + 1, j, r, c, A)
                + UniquePathHelper(i, j + 1, r, c, A);
    }

    static int uniquePathsWithObstacles(int[][] A) {

        int r = A.length;
        int c = A[0].length;

        return UniquePathHelper(0, 0, r, c, A);
    }

    // Driver Code
    public static void main(String[] args) {
        int[][] A = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};

        System.out.print(uniquePathsWithObstacles(A));
    }
}