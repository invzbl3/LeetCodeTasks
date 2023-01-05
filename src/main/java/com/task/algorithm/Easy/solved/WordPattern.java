package com.task.algorithm.Easy.solved;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. Word Pattern
 * https://leetcode.com/problems/word-pattern/
 *
 * Given a pattern and a string s, find if s follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-
 * empty word in s.
 *
 * Example 1:
 *
 * Input: pattern = "abba", s = "dog cat cat dog"
 * Output: true
 *
 * Example 2:
 *
 * Input: pattern = "abba", s = "dog cat cat fish"
 * Output: false
 *
 * Example 3:
 *
 * Input: pattern = "aaaa", s = "dog cat cat dog"
 * Output: false
 *
 * Constraints:
 *
 * * 1 <= pattern.length <= 300
 * * pattern contains only lower-case English letters.
 * * 1 <= s.length <= 3000
 * * s contains only lowercase English letters and spaces ' '.
 * * s does not contain any leading or trailing spaces.
 * * All the words in s are separated by a single space.
 */
public class WordPattern {

    public static void main(String[] args) {
        // String pattern = "abba", s = "dog cat cat dog";
        String pattern = "abba";
        String s = "dog cat cat dog";

        boolean wordPattern = wordPattern(pattern, s);
        System.out.println(wordPattern);
    }

    public static boolean wordPattern(String pattern, String s) {

        String[] chars = s.split(" ");
        Map<Character, String> map = new HashMap<>();
        Map<String, Boolean> map2 = new HashMap<>();

        if (chars.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            if (!map.containsKey(pattern.charAt(i))
                    && map2.containsKey(chars[i])) {
                return false;
            }
            map.put(pattern.charAt(i), chars[i]);
            map2.put(chars[i], true);
        }

        for (int i = 0; i < chars.length; i++) {
            if (!map.get(pattern.charAt(i)).equals(chars[i])) {
                return false;
            }
        }
        return true;
    }
}