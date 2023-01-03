package com.task.algorithm.Hard.solved;

import java.util.*;

/**
 * 140. Word Break II
 * https://leetcode.com/problems/word-break-ii/
 *
 * Given a string s and a dictionary of strings wordDict, add spaces in s to construct a
 * sentence where each word is a valid dictionary word. Return all such possible sentences in any
 * order.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 * Example 1:
 *
 * Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
 * Output: ["cats and dog","cat sand dog"]
 *
 * Example 2:
 *
 * Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
 * Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 *
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: []
 *
 * Constraints:
 *
 * 1 <= s.length <= 20
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 10
 * s and wordDict[i] consist of only lowercase English letters.
 * All the strings of wordDict are unique.
 *
 */
public class WordBreakTwo {

    Map<String, List<String>> map = new HashMap();
    public List<String> wordBreak(String s, List<String> wordDict) {
        if(map.containsKey(s)) {
            return map.get(s);
        }
        List<String> temp = new ArrayList<>();
        int end = s.length();

        for(int i=end-1; i >= 0; i--) {
            String curString = s.substring(i, end);
            if(wordDict.contains(curString)) {
                if(i == 0) {
                    temp.add(curString);
                }
                for(String str : wordBreak(s.substring(0, i), wordDict)) {
                    String res = str + " " + curString;
                    temp.add(res);
                }
            }
        }
        map.put(s, temp);
        return temp;
    }
}

// Simplest solution 78% faster

// Using HashMap to avoid duplicate operation
// Using HashSet to accelerate search process

/*
class Solution {
    Map<String, List<String>> map = new HashMap();

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return wordBreak(s, wordSet);
    }

    public List<String> wordBreak(String s, Set<String> wordSet) {
        if(map.containsKey(s)) {
            return map.get(s);
        }
        List<String> temp = new ArrayList();
        int end = s.length();

        for(int i=end-1; i >= 0; i--) {
            String curString = s.substring(i, end);
            if(wordSet.contains(curString)) {
                if(i == 0) {
                    temp.add(curString);
                }
                for(String str : wordBreak(s.substring(0, i), wordSet)) {
                    String res = str + " " + curString;
                    temp.add(res);
                }
            }
        }
        map.put(s, temp);
        return temp;
    }
}

// Simplest solution 85.89% faster

// Using HashMap to avoid duplicate operation
// Using HashSet to accelerate search process

class Solution {
    HashMap<String, List<String>> map = new HashMap();

    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null) return new ArrayList<>();

        HashSet<String> wordSet = new HashSet(wordDict);
        return wordBreak(s, wordSet);
    }

    public List<String> wordBreak(String s, HashSet<String> wordSet) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        int end = s.length();
        List<String> temp = new ArrayList();
        for (int i = end - 1; i >= 0; i--) {
            String curString = s.substring(i, end);
            if (wordSet.contains(curString)) {
                if (i == 0) {
                    temp.add(curString);
                }
                for (String str : wordBreak(s.substring(0, i), wordSet)) {
                    String res = str + " " + curString;
                    temp.add(res);
                }
            }
        }
        map.put(s, temp);
        return temp;
    }
}*/