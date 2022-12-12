package com.task.algorithm.Medium.solved;

/*
 *   Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 *   The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are
 *   horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 *   Example 1:
 *   Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 *   Output: true
 *
 *   Example 2:
 *   Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 *   Output: true
 *
 *   Example 3:
 *   Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 *   Output: false
 *
 *   Constraints:
 *
 *   - m == board.length
 *   - n = board[i].length
 *   - 1 <= m, n <= 6
 *   - 1 <= word.length <= 15
 *   - board and word consists of only lowercase
 *     and uppercase English letters.
 *
 *   Follow up: Could you use search pruning to make
 *   your solution faster with a larger board?
 * */

class WordSearch {

    private boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 && word.length() != 0) return false;
        visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (isExist(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isExist(char[][] board,
                           String word,
                           int index,
                           int i,
                           int j) {
        if (index == word.length()) return true;
        if (i < 0 || j < 0 || i >= board.length
                  || j >= board[0].length
                  || visited[i][j]
                  || board[i][j] != word.charAt(index))
            return false;
        visited[i][j] = true;
        if (isExist(board, word, index + 1, i + 1, j) ||
                isExist(board, word, index + 1, i, j + 1) ||
                isExist(board, word, index + 1, i - 1, j) ||
                isExist(board, word, index + 1, i, j - 1)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}