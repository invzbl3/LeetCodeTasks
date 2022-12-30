package com.task.algorithm.Medium.solved;

/**
 * Word Dictionary
 *
 *
 */

import java.util.HashMap;

public class WordDictionary {
    static class TrieNodeWithMap {
        boolean isEndOfWord;
        HashMap<Character, TrieNodeWithMap> trieNodeMap;

        TrieNodeWithMap() {
            this.isEndOfWord = false;
            this.trieNodeMap = new HashMap<>();
        }
    }

    private final TrieNodeWithMap root;

    public WordDictionary() {
        this.root = new TrieNodeWithMap();
    }

    public void addWord(String word) {
        TrieNodeWithMap node = root;
        for (int index = 0; index < word.length(); index++) {
            char character = word.charAt(index);
            if (!node.trieNodeMap.containsKey(character)) node.trieNodeMap.put(character, new TrieNodeWithMap());
            node = node.trieNodeMap.get(character);
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        return searchRec(word, root, 0);
    }

    private boolean searchRec(String word, TrieNodeWithMap node, int index) {
        if (node == null) return false;
        if (index == word.length()) return node.isEndOfWord;
        char character = word.charAt(index);
        if (character == '.') {
            for (Character ch : node.trieNodeMap.keySet()) {
                boolean isFound = searchRec(word, node.trieNodeMap.get(ch), index + 1);
                if (isFound) return true;
            }
        } else if (!node.trieNodeMap.containsKey(character)) return false;
        return searchRec(word, node.trieNodeMap.get(character), index + 1);
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("a");
        wordDictionary.addWord("a");
        System.out.println(wordDictionary.search("."));
        System.out.println(wordDictionary.search("a"));
        System.out.println(wordDictionary.search("aa"));
        System.out.println(wordDictionary.search("a"));
        System.out.println(wordDictionary.search(".a"));
        System.out.println(wordDictionary.search("a."));
    }
}

/*
import java.util.*;
import java.util.regex.Pattern;

class WordDictionary {
    ArrayList<String> arr;
    HashMap<String, Integer> map;

    public WordDictionary() {
        arr = new ArrayList<>();
        map = new HashMap<>();
    }

    void addWord(String x) {
        if (map.get(x) != null)
            return;

        int s = arr.size();
        arr.add(x);
        map.put(x, s);
    }

    void search(String x) {
        if (map.get(x) != null) {
            System.out.println("True");
            return;
        } else {
            Pattern regex = Pattern.compile(x);

            for (String s : arr) {
                if (regex.matcher(s).matches()) {
                    System.out.println("True");
                    return;
                }
            }
        }
        System.out.println("False");
    }
}

class Main2 {
    public static void main(String[] args) {
        WordDictionary ds = new WordDictionary();

        ds.addWord("code");
        ds.addWord("java");
        ds.addWord("when");

        ds.search("blue");
        ds.search("java");
        ds.search("co..");
    }
}*/