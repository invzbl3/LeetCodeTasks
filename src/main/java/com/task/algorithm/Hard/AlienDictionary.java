package com.task.algorithm.Hard;

import java.util.*;

/*
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

/**
 * @author invzbl3 on 12/4/2022
 * @project LeetCodeTask
 */
public class AlienDictionary {

    public static void main(String[] args) {
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        System.out.println(alienOrder(words));
    }

    public static String alienOrder(String[] words) {
        int numWords = words.length;
        Map<Character, String> wordDependencies = new HashMap<>();
        Set<Character> uniqueChars = new HashSet<>();
        //create a unique list of chars
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                uniqueChars.add(word.charAt(i));
            }
        }
        //create a dependency map
        for (int i = 1; i < numWords; i++) {
            String wordA = words[i - 1];
            String wordB = words[i];
            int inLen = Math.min(wordA.length(), wordB.length());
            int index = 0;
            while (index < inLen && wordA.charAt(index) == wordB.charAt(index)) {
                index++;
            }
            if (index < inLen) {
                String strDep = wordDependencies.getOrDefault(wordA.charAt(index), "");
                strDep = strDep + wordB.charAt(index);
                wordDependencies.put(wordA.charAt(index), strDep);
            }
        }

        StringBuilder builder = new StringBuilder();
        Set<Character> visited = new HashSet<>();
        //iterate through the unique chars while like running toposort to process dependencies
        for (Character ch : uniqueChars) {
            if (!visited.contains(ch)) {
                Set<Character> visiting = new HashSet<>();
                int val = topoSort(wordDependencies, builder, visited, ch, visiting);
                if (val != 0) {
                    return "";
                }
            }
        }
        return builder.reverse().toString();
    }

    /**
     * process the char dependencies via running toposort
     *
     * @param wordDependencies
     * @param builder
     * @param visited
     * @param ch
     * @param visiting
     * @return
     */
    static int topoSort(Map<Character, String> wordDependencies, StringBuilder builder, Set<Character> visited,
                        Character ch, Set<Character> visiting) {
        visiting.add(ch);
        String dep = wordDependencies.get(ch);
        if (null != dep) {
            for (int i = 0; i < dep.length(); i++) {
                Character depCh = dep.charAt(i);
                if (visiting.contains(depCh)) {
                    return -1;
                } else if (!visited.contains(depCh)) {
                    int val = topoSort(wordDependencies, builder, visited, depCh, visiting);
                    if (val != 0) {
                        return val;
                    }
                }
            }
        }
        visiting.remove(ch);
        visited.add(ch);
        builder.append(ch);
        return 0;
    }
}