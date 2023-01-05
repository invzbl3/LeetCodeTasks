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

        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;
        for (int j = 1; j <= s.length(); j++) dp[0][j] = false;
        for (int i = 1; i <= p.length(); i++) dp[i][0] = p.charAt(i - 1) == '*' && dp[i - 1][0];

        for (int i = 1; i <= p.length(); i++) {
            char c = p.charAt(i - 1);
            for (int j = 1; j <= s.length(); j++) {
                switch (c) {
                    case '?':
                        dp[i][j] = dp[i - 1][j - 1];
                        break;
                    case '*':
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - 1] || dp[i][j - 1];
                        break;
                    default:
                        dp[i][j] = c == s.charAt(j - 1) && dp[i - 1][j - 1];
                }
            }
        }
        return dp[p.length()][s.length()];
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