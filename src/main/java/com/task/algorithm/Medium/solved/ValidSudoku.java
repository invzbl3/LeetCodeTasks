package com.task.algorithm.Medium.solved;

/**
 * 36. Valid Sudoku
 * https://leetcode.com/problems/valid-sudoku/
 *
 * Determine if a 9 x 9 Sudoku board is valid.
 * Only the filled cells need to be validated according
 * to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * Note:
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 *
 * Example 1:
 *
 * Input: board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: true
 *
 * Example 2:
 *
 * Input: board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left
 * corner being modified to 8. Since there are two 8's in the top left
 * 3x3 sub-box, it is invalid.
 *
 * Constraints:
 *
 * * board.length == 9
 * * board[i].length == 9
 * * board[i][j] is a digit 1-9 or '.'.
 */
class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length > 9 || board[0].length > 9) {
            return false;
        }
        return backtrack(board, 0, 0);
    }

    public boolean backtrack(char[][] board, int r, int c) {
        int m = 9;
        int n = 9;
        if (c == n) {
            return backtrack(board, r + 1, 0);
        }
        if (r == m) {
            return true;
        }
        if (board[r][c] == '.') {
            return backtrack(board, r, c + 1);
        }
        if (board[r][c] != '.') {
            if (!isValid(board, r, c)) {
                return false;
            }
            return backtrack(board, r, c + 1);
        }
        return true;
    }

    public boolean isValid(char[][] board, int r, int c) {
        char ch = board[r][c];
        for (int k = 0; k < 9; k++) {
            if (board[r][k] == ch) {
                if (k != c) {
                    return false;
                }
            }
            if (board[k][c] == ch) {
                if (k != r) {
                    return false;
                }
            }
            if (board[(r / 3) * 3 + k / 3][(c / 3) * 3 + k % 3] == ch) {
                if ((r / 3) * 3 + k / 3 != r && (c / 3) * 3 + k % 3 != c) {
                    return false;
                }
            }
        }
        return true;
    }
}