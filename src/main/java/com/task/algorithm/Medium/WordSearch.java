package com.task.algorithm.Medium;

/**
 * 79. Word Search
 * https://leetcode.com/problems/word-search/
 *
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or
 * vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example 1:
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 *
 * Example 2:
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 *
 * Example 3:
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 *
 * Constraints:
 *
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board and word consists of only lowercase and uppercase English letters.
 *
 */
public class WordSearch {
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

    public boolean isExist(char[][] board, String word, int index, int i, int j) {
        if (index == word.length()) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index))
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

/*
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

    static Scanner input;
    static char[][] wordList;
    static char[][] board;
    static char[][] output;

    static int foundRow;
    static int foundColumn;
    static int currentWord;

    public static void main(String[] args) throws FileNotFoundException {
        File wordInput = new File("words.txt");
        File boardInput = new File("board.txt");
        if (!wordInput.exists() || !boardInput.exists()) {
            System.out.println("Files do not exist.");
            System.exit(1);
        }

        wordList = new char[3][];   //word list matrix
        board = new char[4][4]; //board or grid matrix
        output = new char[4][4]; //solved puzzle

        fillWithSpaces(output);

        input = new Scanner(wordInput);
        for (int i = 0; i < wordList.length; i++) {
            wordList[i] = input.nextLine().toUpperCase().toCharArray();
        }

        input = new Scanner(boardInput);
        for (int i = 0; i < board[0].length; i++) {
            board[i] = input.nextLine().toUpperCase().toCharArray();
        }

        for (int i = 0; i < wordList.length; i++) {
            currentWord = i;
            if (findFirstLetter()) {
                checkEachDirection();
            }
        }
        print(output);
    }

    static boolean findFirstLetter() {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board.length; c++) {
                if (wordList[currentWord][0] == board[r][c]) {
                    foundRow = r;
                    foundColumn = c;
                    return true;
                }
            }
        }
        return false;
    }

    static void checkEachDirection() {
        checkForwards();
        checkBackwards();
        //checkUp();
        //checkDown();
        checkDiagonalDown();
        //checkDiagonalUp();
    }

    static void checkForwards() {
        for (int i = 1; i < wordList[currentWord].length; i++) {
            if (foundColumn + i > board.length - 1) return;
            if (wordList[currentWord][i] != board[foundRow][foundColumn + i]) return;
        }
        //if we got to here, update the output
        System.arraycopy(wordList[currentWord], 0, output[foundRow], foundColumn, wordList[currentWord].length);
    }

    static void checkBackwards() {
        for (int i = 1; i < wordList[currentWord].length; i++) {
            if (foundColumn - i < 0) return;
            if (wordList[currentWord][i] != board[foundRow][foundColumn - i]) return;
        }
        //if we got to here, update the output
        for (int i = 0; i < wordList[currentWord].length; i++) {
            output[foundRow][foundColumn - i] = wordList[currentWord][i];
        }
    }

    static void checkDiagonalDown() {
        for (int i = 1; i < wordList[currentWord].length; i++) {
            if (foundColumn + i > board.length - 1) return;
            if (foundRow + i > board.length - 1) return;
            if (wordList[currentWord][i] != board[foundRow + i][foundColumn + i]) return;
        }
        //if we got to here, update the output
        for (int i = 0; i < wordList[currentWord].length; i++) {
            output[foundRow + i][foundColumn + i] = wordList[currentWord][i];
        }
    }

    static void print(char[][] board) {
        for (char[] chars : board) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(chars[j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    static void fillWithSpaces(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '-';
            }
        }
    }
}*/
