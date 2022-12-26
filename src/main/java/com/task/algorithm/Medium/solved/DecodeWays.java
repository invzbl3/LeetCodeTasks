package com.task.algorithm.Medium.solved;

import java.util.Arrays;

/**
 * 91. Decode Ways
 * https://leetcode.com/problems/decode-ways/
 *
 * A message containing letters from A-Z can be encoded into numbers using the following
 * mapping:
 *
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 *
 * To decode an encoded message, all the digits must be grouped then mapped back into letters
 * using the reverse of the mapping above (there may be multiple ways). For example, "11106"
 * can be mapped into:
 *
 * "AAJF" with the grouping (1 1 10 6)
 * "KJF" with the grouping (11 10 6)
 *
 * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since
 * "6" is different from "06".
 *
 * Given a string s containing only digits, return the number of ways to decode it.
 * The test cases are generated so that the answer fits in a 32-bit integer.
 *
 * Example 1:
 *
 * Input: s = "12"
 * Output: 2
 * Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
 *
 * Example 2:
 *
 * Input: s = "226"
 * Output: 3
 * Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6),
 * or "BBF" (2 2 6).
 *
 * Example 3:
 *
 * Input: s = "06"
 * Output: 0
 * Explanation: "06" cannot be mapped to "F" because of the leading
 * zero ("6" is different from "06").
 *
 * Constraints:
 * 1 <= s.length <= 100
 * s contains only digits and may contain leading zero(s).
 *
 *
 * An alternative algorithm description:
 * -------------------------------------
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 *
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 *
 * The number of ways decoding "12" is 2.
 * Solution : DP
 * because of '0' may exist in s, so calculate from right to left will ignore invalid situation
 * such as s="10",
 * ways[i]=   0 if s.charAt(i)=='0'
 * or
 * ways[i+1] if s.charAt(i)!='0',
 * + ways[i+1]+ways[i+2] if s.charAt(i)=='1' || s.charAt(i)=='2' && s.charAt(i+1)<='6'
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // declare ways array with two extra space, because ways[i] also affect by ways[i+2]
        int[] ways = new int[s.length() + 2];


        Arrays.fill(ways, 1);
        int i = s.length() - 1;

        ways[i] = s.charAt(i) == '0' ? 0 : 1;

        for (i = i - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                // if current digit is '0', so no mater what right is, current ways should be 0;
                ways[i] = 0;
            } else {
                // if current digit is not '0', current ways should be ways[i+1]
                // because, for example s="12", i=0, ways[1]=1, then because current digit is not zero, so for
                // each situation of when i=1, the current i=0 should  be a valid way,
                ways[i] = ways[i + 1];

                // check is current digit with right 1 digit can be a valid situation,so in this situation only s.charAt(i)=='1'||
                // s.charAt(i)=='2' and s.charAt(i+1)<='6' can be valid situation, the ways[i] should + ways[i+2];
                if (i + 2 < ways.length && s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) <= '6') {
                    ways[i] += ways[i + 2];
                }
            }
        }
        return ways[0];
    }
}