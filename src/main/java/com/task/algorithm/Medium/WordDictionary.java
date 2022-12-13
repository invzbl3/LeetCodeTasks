package com.task.algorithm.Medium;

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
}