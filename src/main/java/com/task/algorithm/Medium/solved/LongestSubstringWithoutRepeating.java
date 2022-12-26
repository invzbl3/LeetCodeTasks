package com.task.algorithm.Medium.solved;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Constraints:
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 10^4
 * s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeating sol = new LongestSubstringWithoutRepeating();
        System.out.println(sol.lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(sol.lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(sol.lengthOfLongestSubstring("pwwkew")); // 3
        System.out.println(sol.lengthOfLongestSubstring("")); // 0
        System.out.println(sol.lengthOfLongestSubstring("a")); // 1
        System.out.println(sol.lengthOfLongestSubstring("abcd")); // 4
        System.out.println(sol.lengthOfLongestSubstring("aabcd")); // 4
        System.out.println(sol.lengthOfLongestSubstring("aab")); // 2
        System.out.println(sol.lengthOfLongestSubstring("cdd")); // 2
        System.out.println(sol.lengthOfLongestSubstring("abba")); // 2
        System.out.println(sol.lengthOfLongestSubstring("aabaab!bb")); // 3
        System.out.println(sol.lengthOfLongestSubstring("tmmzuxt")); // 5
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;

        int n = s.length();
        int start = 0;
        int len = 1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                if (map.get(ch) >= start) start = map.get(ch) + 1;
            }
            len = Math.max(len, i - start + 1);
            map.put(ch, i);
        }
        return map.size() == n ? n : len;
    }
}