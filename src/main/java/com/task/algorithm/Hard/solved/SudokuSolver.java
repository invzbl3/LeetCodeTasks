package com.task.algorithm.Hard.solved;

import java.util.Arrays;

/**
 * 37. Sudoku Solver
 * https://leetcode.com/problems/sudoku-solver/
 *
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * A sudoku solution must satisfy all of the following rules:
 *
 * Each of the digits 1-9 must occur exactly once in each row.
 *
 * Each of the digits 1-9 must occur exactly once in each column.
 *
 * Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 *
 * The '.' character indicates empty cells.
 *
 * Example 1:
 *
 * Input: board =
 * [["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]]
 * Output:
 * [["5","3","4","6","7","8","9","1","2"],
 * ["6","7","2","1","9","5","3","4","8"],
 * ["1","9","8","3","4","2","5","6","7"],
 * ["8","5","9","7","6","1","4","2","3"],
 * ["4","2","6","8","5","3","7","9","1"],
 * ["7","1","3","9","2","4","8","5","6"],
 * ["9","6","1","5","3","7","2","8","4"],
 * ["2","8","7","4","1","9","6","3","5"],
 * ["3","4","5","2","8","6","1","7","9"]]
 * Explanation: The input board is
 * shown above and the only valid
 * solution is shown below:
 * 
 * | 5 | 3 | 4 | 6 | 7 | 8 | 9 | 1 | 2 |
 * | 6 | 7 | 2 | 1 | 9 | 5 | 3 | 4 | 8 |
 * | 1 | 9 | 8 | 3 | 4 | 2 | 5 | 6 | 7 |
 * | 8 | 5 | 9 | 7 | 6 | 1 | 4 | 2 | 3 |
 * | 4 | 2 | 6 | 8 | 5 | 3 | 7 | 9 | 1 |
 * | 7 | 1 | 3 | 9 | 2 | 4 | 8 | 5 | 6 |
 * | 9 | 6 | 1 | 5 | 3 | 7 | 2 | 8 | 4 |
 * | 2 | 8 | 7 | 4 | 1 | 9 | 6 | 3 | 5 |
 * | 3 | 4 | 5 | 2 | 8 | 6 | 1 | 7 | 9 |
 *
 * Constraints:
 *
 * * board.length == 9
 * * board[i].length == 9
 * * board[i][j] is a digit or '.'.
 * * It is guaranteed that the input board has only
 *   one solution.
 */
class SudokuSolver {
    boolean finish = false;

    public void solveSudoku(char[][] board) {
        solveSudoku(board, 0, 0);
    }

    public void solveSudoku(char[][] board, int x, int y) {
        if (board[x][y] == '.') {
            for (char i = '1'; i <= '9'; i++) {
                if (check(board, x, y, i)) {
                    board[x][y] = i;
                    if (x == 8 && y == 8) finish = true;
                    if (y < 8) solveSudoku(board, x, y + 1);
                    else if (x < 8) solveSudoku(board, x + 1, 0);
                    if (finish) break;
                    board[x][y] = '.';
                }
            }
        } else {
            if (x == 8 && y == 8) {
                finish = true;
                return;
            }
            if (y < 8) solveSudoku(board, x, y + 1);
            else if (x < 8) solveSudoku(board, x + 1, 0);
        }
    }

    public boolean check(char[][] board, int x, int y, char value) {
        for (int i = 0; i < 9; i++) {
            if (board[i][y] == value) return false;
            if (board[x][i] == value) return false;
        }

        int groupX = x / 3;
        int groupY = y / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[groupX * 3 + i][groupY * 3 + j] == value) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        SudokuSolver s = new SudokuSolver();
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        s.solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }
}