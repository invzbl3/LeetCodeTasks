package com.task.algorithm.Medium.solved;

import java.util.List;
import java.util.ArrayList;

/*
 * 139. Word Break
 * https://leetcode.com/problems/word-break/
 *
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented
 * into a space-separated sequence of one or more dictionary words.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as
 * "leet code".
 *
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented
 * as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 *
 * Example 3:
 *
 * Input: s = "catsandog", wordDict =
 * ["cats","dog","sand","and","cat"]
 * Output: false
 *
 * Constraints:
 *
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s and wordDict[i] consist of only lowercase English letters.
 * All the strings of wordDict are unique.
 *
 */
class WordBreakProblem {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak(s, wordDict));

    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        // dp[0] is true bcz an empty string can always be segmented
        dp[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

/*
class Main {
    // Function to segment given string into a space-separated
    // sequence of one or more dictionary words

    public static void wordBreak(List<String> dict, String word, String out) {
        // if the end of the string is reached,
        // print the output string

        if (word.length() == 0) {
            System.out.println(out);
            return;
        }

        for (int i = 1; i <= word.length(); i++) {
            // consider all prefixes of the current string
            String prefix = word.substring(0, i);

            // if the prefix is present in the dictionary, add it to the
            // output string and recur for the remaining string

            if (dict.contains(prefix)) {
                wordBreak(dict, word.substring(i), out + " " + prefix);
            }
        }
    }

    // Word Break Problem Implementation in Java
    public static void main(String[] args) {
        // List of strings to represent a dictionary
        List<String> dict = Arrays.asList("this", "th", "is", "famous", "Word",
                "break", "b", "r", "e", "a", "k", "br", "bre", "brea", "ak", "problem");

        // input string
        String word = "Wordbreakproblem";

        wordBreak(dict, word, "");
    }
}*/
