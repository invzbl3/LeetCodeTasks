package com.task.algorithm.Hard.solved;

/**
 * 44. Wildcard Matching
 * https://leetcode.com/problems/wildcard-matching/
 *
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?'
 * and '*' where:
 *
 * * '?' Matches any single character.
 * * '*' Matches any sequence of characters (including the empty sequence).
 *
 * The matching should cover the entire input string (not partial).
 *
 * Example 1:
 *
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 *
 * Example 2:
 *
 * Input: s = "aa", p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 *
 * Example 3:
 *
 * Input: s = "cb", p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 *
 * Constraints:
 *
 * * 0 <= s.length, p.length <= 2000
 * * s contains only lowercase English letters.
 * * p contains only lowercase English letters, '?' or '*'.
 */
class WildcardMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        return isMatch(s, 0, p, 0);
    }

    private boolean isMatch(String s, int i, String p, int j) {
        if (i >= s.length()) return restAreStars(p, j);
        if (j >= p.length()) return false;

        switch (p.charAt(j)) {
            case '?':
                return isMatch(s, i+1, p, j+1);
            case '*':
                while (j+1 < p.length() && p.charAt(j+1) == '*') j++;
                return isMatch(s, i, p, j+1) || isMatch(s, i+1, p, j+1) || isMatch(s, i+1, p, j);
            default:
                return s.charAt(i) == p.charAt(j) && isMatch(s, i+1, p, j+1);
        }
    }

    private boolean restAreStars(String p, int j) {
        while (j < p.length()) {
            if (p.charAt(j) != '*') return false;
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        WildcardMatching wildcardMatching = new WildcardMatching();
        System.out.println(wildcardMatching.isMatch("ab", ".*c"));
        System.out.println(wildcardMatching.isMatch("aa", "a*"));
        System.out.println(wildcardMatching.isMatch("adwbbci", ".*bci"));
        System.out.println(wildcardMatching.isMatch("aaa", "ab*a"));
        System.out.println(wildcardMatching.isMatch("aaa", "ab*a*c*a"));
    }
}