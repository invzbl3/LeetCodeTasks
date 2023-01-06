package com.task.algorithm.Hard.solved;

/**
 * 65. Valid Number
 * https://leetcode.com/problems/valid-number/
 *
 * A valid number can be split up into these components (in order):
 *
 * A decimal number or an integer.
 * (Optional) An 'e' or 'E', followed by an integer.
 * A decimal number can be split up into these components (in order):
 *
 * (Optional) A sign character (either '+' or '-').
 * One of the following formats:
 * One or more digits, followed by a dot '.'.
 * One or more digits, followed by a dot '.', followed by one or more digits.
 * A dot '.', followed by one or more digits.
 * An integer can be split up into these components (in order):
 *
 * (Optional) A sign character (either '+' or '-').
 * One or more digits.
 * For example, all the following are valid numbers: ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"], while the following are not valid numbers: ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"].
 *
 * Given a string s, return true if s is a valid number.
 *
 * Example 1:
 *
 * Input: s = "0"
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "e"
 * Output: false
 *
 * Example 3:
 *
 * Input: s = "."
 * Output: false
 *
 * Constraints:
 *
 * * 1 <= s.length <= 20
 * * s consists of only English letters (both uppercase and lowercase), digits (0-9), plus '+',
 * minus '-', or dot '.'.
 */
public class ValidNumber {

    public boolean isNumber(String s) {
        if (s == null || s.trim().length() == 0) {
            return false;
        }
        boolean numSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;
        boolean numberAfterE = false;

        s = s.trim();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                numberAfterE = true;
                numSeen = true;
            } else if (c == 'e' || c == 'E') {
                if (!numSeen || eSeen) {
                    return false;
                }
                numberAfterE = false;
                eSeen = true;
            } else if (c == '.') {
                if (dotSeen || eSeen) {
                    return false;
                }
                dotSeen = true;
            } else if (c == '+' || c == '-') {
                if (i > 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }

        }
        return numSeen && numberAfterE;
    }

    public static void main(String[] args) {
        ValidNumber isNumber = new ValidNumber();
        System.out.println("0==>" + isNumber.isNumber("0"));
        System.out.println(" 0.1  ==>" + isNumber.isNumber(" 0.1 "));
        System.out.println("abc ==>" + isNumber.isNumber("abc"));
        System.out.println(isNumber.isNumber("1 a"));
        System.out.println(isNumber.isNumber("2e10"));
        System.out.println("53.5e93 ==>" + isNumber.isNumber("53.5e93"));
        System.out.println(isNumber.isNumber("959440.94f"));
    }
}