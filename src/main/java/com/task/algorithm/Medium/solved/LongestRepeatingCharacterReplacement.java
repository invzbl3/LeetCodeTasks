package com.task.algorithm.Medium.solved;

/**
 * 424. Longest Repeating Character Replacement
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 *
 * You are given a string s and an integer k.
 * You can choose any character of the string and change it to any other uppercase English character.
 * You can perform this operation at most k times.
 *
 * Return the length of the longest substring containing the same letter you can get after performing
 * the above operations.
 *
 * Example 1:
 *
 * Input: s = "ABAB", k = 2
 * Output: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 *
 * Example 2:
 *
 * Input: s = "AABABBA", k = 1
 * Output: 4
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 *
 * Constraints:
 *
 * 1 <= s.length <= 10^5
 * s consists of only uppercase English letters.
 * 0 <= k <= s.length
 */
public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        char[] str = s.toCharArray();
        int[] count = new int[26];
        int maxCount = 0;
        int left = 0;
        int res = 0;
        for (int right = 0; right < s.length(); right++) {
            count[str[right] -'A']++;
            maxCount = Math.max(maxCount, count[str[right]  - 'A']);
            if (right - left + 1 - maxCount <= k) {
                res = Math.max(res, right - left + 1);
            } else {
                count[str[left]  - 'A']--;
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement solution = new LongestRepeatingCharacterReplacement();
        solution.characterReplacement("AABABBA", 1);
    }
}