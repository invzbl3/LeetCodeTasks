package com.task.algorithm.Medium;

import java.util.*;
import java.util.regex.Pattern;

class AddAndSearchWord {
    ArrayList<String> arr;
    HashMap<String, Integer> map;

    public AddAndSearchWord() {
        arr = new ArrayList<>();
        map = new HashMap<>();
    }

    void addword(String x) {
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
        AddAndSearchWord ds = new AddAndSearchWord();

        ds.addword("code");
        ds.addword("java");
        ds.addword("when");

        ds.search("blue");
        ds.search("java");
        ds.search("co..");
    }
}