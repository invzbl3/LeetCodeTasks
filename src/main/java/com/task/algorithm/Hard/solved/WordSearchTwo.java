package com.task.algorithm.Hard.solved;

import java.util.*;

/**
 * 212. Word Search II
 * https://leetcode.com/problems/word-search-ii/description/
 *
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells
 * are horizontally or vertically neighboring. The same letter cell may not be used more than once
 * in a word.
 *
 * Example 1:
 *
 * Input: board = [["o","a","a","n"],["e","t","a","e"],
 * ["i","h","k","r"],["i","f","l","v"]], words =
 * ["oath","pea","eat","rain"]
 * Output: ["eat","oath"]
 *
 * Example 2:
 *
 * Input: board = [["a","b"],["c","d"]], words = ["abcb"]
 * Output: []
 *
 * Constraints:
 *
 * * m == board.length
 * * n == board[i].length
 * * 1 <= m, n <= 12
 * * board[i][j] is a lowercase English letter.
 * * 1 <= words.length <= 3 * 104
 * * 1 <= words[i].length <= 10
 * * words[i] consists of lowercase English letters.
 * All the strings of words are unique.
 *
 */
public class WordSearchTwo {
    public List<String> findWords1(char[][] board, String[] words) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            label : for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (findWords(board, chars, i, j, 0)) {
                        list.add(word);
                        break label;
                    }
                }
            }

        }
        return list;
    }

    public List<String> findWords2(char[][] board, String[] words) {
        Map<Character, List<Integer>> map = new HashMap<>(26);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                List<Integer> indexes = map.computeIfAbsent(board[i][j], k -> new ArrayList<>());
                indexes.add(i << 4 | j);
            }
        }

        List<String> list = new ArrayList<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            List<Integer> indexes = map.get(chars[0]);
            if (indexes == null || indexes.isEmpty()) {
                continue;
            }
            for (Integer index : indexes) {
                if (findWords(board, chars, index >>> 4, index & 0xF, 0)) {
                    list.add(word);
                    break;
                }
            }
        }
        return list;
    }

    private boolean findWords(char[][] board, char[] words, int i, int j, int index) {
        if (words[index] != board[i][j]) {
            return false;
        }
        if (++index == words.length) {
            return true;
        }

        board[i][j] = 0;
        boolean match = j < board[i].length - 1 && findWords(board, words, i, j + 1, index)
                || j > 0 && findWords(board, words, i, j - 1, index)
                || i < board.length - 1 && findWords(board, words, i + 1, j, index)
                || i > 0 && findWords(board, words, i - 1, j, index);
        board[i][j] = words[index - 1];
        return match;
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        Set<String> ans = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, trie, i, j, ans);
            }
        }

        return new ArrayList<>(ans);
    }

    public void dfs(char[][] board, Trie now, int i, int j, Set<String> ans) {
        char ch = board[i][j];
        if (!now.children.containsKey(ch)) {
            return;
        }
        Trie nxt = now.children.get(ch);
        if (!nxt.word.isEmpty()) {
            ans.add(nxt.word);
            nxt.word = "";
        }

        if (!nxt.children.isEmpty()) {
            board[i][j] = 0;
            if (j > 0) {
                dfs(board, nxt, i, j - 1, ans);
            }
            if (j < board[0].length - 1) {
                dfs(board, nxt, i, j + 1, ans);
            }
            if (i > 0) {
                dfs(board, nxt, i - 1, j, ans);
            }
            if (i < board.length - 1) {
                dfs(board, nxt, i + 1, j, ans);
            }
            board[i][j] = ch;
        }

        if (nxt.children.isEmpty()) {
            now.children.remove(ch);
        }
    }

    static class Trie {
        String word;
        Map<Character, Trie> children;

        public Trie() {
            this.word = "";
            this.children = new HashMap<>();
        }

        public void insert(String word) {
            Trie cur = this;
            for (char c : word.toCharArray()) {
                cur = cur.children.computeIfAbsent(c, k -> new Trie());
            }
            cur.word = word;
        }
    }
}