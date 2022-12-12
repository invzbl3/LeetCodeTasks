package com.task.algorithm.Hard.solved;

import java.util.HashMap;
import java.util.Map;

/*
    Algorithm description:
    ---------------------
    There is a new alien language which uses the latin alphabet.
    However, the order among letters are unknown to you.
    You receive a list of words from the dictionary, where words are sorted lexicographically
    by the rules of this new language.
    Derive the order of letters in this language.
    For example, Given the following words in dictionary,
    [
    "wrt",
    "wrf",
    "er",
    "ett",
    "rftt"
    ]
    The correct order is: "wertf".
    [
    "wrtf",
    "wrt"
    ]
    return "" because the first one has more chars than second one
*/
public class AlienDictionary {
/*    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();
        StringBuilder result = new StringBuilder();
        if (words == null || words.length == 0) { return result.toString(); }
        // Degree char = 0
        for (String s : words) {
            for (char c : s.toCharArray()) {
                degree.put(c, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String curr = words[i];
            String next = words[i + 1];
            int min = Math.min(curr.length(), next.length());
            for (int j = 0; j < min; j++) {
                char c1 = curr.charAt(j);
                char c2 = next.charAt(j);
                if (c1 != c2) {
                    Set<Character> set = map.getOrDefault(c1, new HashSet<>());
                    if (!set.contains(c2)) {
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2) + 1); // update c2, c1 < c2
                    }
                    break;
                }
            }
        }

        LinkedList<Character> q = new LinkedList<>();
        for (char c: degree.keySet()) {
            if (degree.get(c) == 0) {
                q.add(c);
            }
        }

        while (!q.isEmpty()) {
            char c = q.poll();
            result.append(c);
            if (map.containsKey(c)) {
                for (char next: map.get(c)) {
                    degree.put(next, degree.get(next) - 1);
                    if (degree.get(next) == 0) {
                        q.offer(next);
                    }
                }
            }
        }
        return result.length() == degree.size() ? result.toString() : "";
    }*/

    public class Solution {
        int index = 0;
        Map<Character, Integer> map = new HashMap<>();

        public boolean isAlienSorted(String[] words, String order) {
            for (int i = 0; i < order.length(); i++) {
                map.put(order.charAt(i), i);
            }
            map.put(' ', -1);

            while (true) {
                if (index == words.length - 1) return true;
                if (isSorted(words[index], words[index + 1])) {
                    index++;
                } else {
                    return false;
                }
            }
        }

        private boolean isSorted(String o1, String o2) {
            char[] lastArray = o1.toCharArray();
            char[] newArray = o2.toCharArray();

            int length = Math.max(lastArray.length, newArray.length);

            for (int i = 0; i < length; i++) {
                char last_char = i < lastArray.length ? lastArray[i] : ' ';
                char new_char = i < newArray.length ? newArray[i] : ' ';

                if (map.get(last_char) < map.get(new_char)) return true;
                else if (map.get(last_char) > map.get(new_char)) return false;
            }

            return true;
        }
    }
}