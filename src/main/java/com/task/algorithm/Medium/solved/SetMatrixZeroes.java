package com.task.algorithm.Medium.solved;

import java.util.ArrayList;
import java.util.List;

/**
 * 73. Set Matrix Zeroes
 * https://leetcode.com/problems/set-matrix-zeroes/
 *
 * Given an m x n integer matrix matrix, if an element is 0,
 * set its entire row and column to 0's.
 *
 * You must do it in place:
 * https://en.wikipedia.org/wiki/In-place_algorithm
 *
 * Example 1:
 *
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 *
 * Example 2:
 *
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 * Constraints:
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -2^31 <= matrix[i][j] <= 2^31 - 1
 *
 * Follow up:
 * A straightforward solution using O(mn) space
 * is probably a bad idea.
 *
 * A simple improvement uses O(m + n) space,
 * but still not the best solution.
 *
 * Could you devise a constant space solution?
 */
class SetMatrixZeroes {
    public static void main(String[] args) {

        int[][] arr = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(arr);
        System.out.println("The Final Matrix is ");
        for (int[] ints : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for (Integer integer : row) {
            for (int j = 0; j < n; j++) {
                matrix[integer][j] = 0;
            }
        }

        for (Integer integer : col) {
            for (int j = 0; j < m; j++) {
                matrix[j][integer] = 0;
            }
        }
    }
}

/*    static void setZeroes(int[][] matrix) {
        int call = 1;
        int rows = matrix.length;
        int col = matrix[0].length;

        //checking if the matrix[0][0] -> first element of first coloumn in any of the row is zero or not.
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) call = 0;
            //now using loop for coloumn to traverse nad make
            //the arbitrary arrays to zero
            for (int j = 0; j < col; j++)
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
        }

        *//*now traversing from back to not affect array elements be affected *//*
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;

                if (call == 0) matrix[i][0] = 0;
            }
        }
    }
}*/

/* Time complexity -> O(2*(n*m)) -> as we are traversing n array m times
Space complexity -> O(1) */

/*
class SetMatrixZeros {
    //function to set matrix elements to zeros
    private static void setZeros(int[][] matrix, int n, int m) {
        int[][] answer = new int[n][m];
        //set all elements of the array as 1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer[i][j] = 1;
            }
        }
        //traversing over matrix row wise
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    // Set this row as zero in answer array
                    for (int k = 0; k < m; k++) {
                        answer[i][k] = 0;
                    }
                    break;
                }
            }
        }
        //traversing over matrix column wise
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (matrix[i][j] == 0) {
                    //set this column as 0 in answer array
                    for (int k = 0; k < n; k++) {
                        answer[k][j] = 0;
                    }
                }
            }
        }
        // Updating the elements in matrix array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (answer[i][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        //defining an array
        int[][] matrix = new int[][]{{0, 6, 3, 0}, {1, 8, 9, 3}, {6, 2, 0, 7}};
        //finds the length of the matrix
        int n = matrix.length;
        int m = matrix[0].length;
        //function calling
        setZeros(matrix, n, m);
        for (int[] ints : matrix) {
            for (int j = 0; j < m; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}*/