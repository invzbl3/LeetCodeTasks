package com.task.algorithm.Medium.solved;

/**
 * 647. Palindromic Substrings
 * https://leetcode.com/problems/palindromic-substrings/
 *
 * Given a string s, return the number of palindromic substrings in it.
 *
 * A string is a palindrome when it reads the same backward as forward.
 *
 * A substring is a contiguous sequence of characters within the string.
 *
 * Example 1:
 *
 * Input: s = "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 *
 * Example 2:
 *
 * Input: s = "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa",
 * "aaa".
 *
 * Constraints:
 * 1 <= s.length <= 1000
 * s consists of lowercase English letters.
 */
public class PalindromicSubstrings {
    // count the number of palindromic strings
    public int countSubstrings(String s) {

        // center expansion algorithm to verify the palindrome string,
        // a total of 2n - 1 positions can be used as the center of the palindrome string
        int n = s.length();
        int ans = 0;
        for (int center = 0; center <= 2 * n - 1; ++center) {
            int left = center / 2;
            int right = left + center % 2;
            // center expansion
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }
}