package com.task.algorithm.Easy.solved;

/**
 * @author invzbl3 on 12/4/2022
 * @project LeetCodeTask
 */

/*
    Algorithm description:
    ---------------------
    A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and
    removing all non-alphanumeric characters, it reads the same forward and backward.
    Alphanumeric characters include letters and numbers.

    Given a string s, return true if it is a palindrome, or false otherwise.

    Valid Palindrome
    Given a string, determine if it is a palindrome, considering only alphanumeric characters and
    ignoring cases.

    For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car" is not a palindrome.

    Note: Have you consider that the string might be empty? This is a good question to ask during an
    interview.
 */

// https://leetcode.com/problems/valid-palindrome/
// https://mosqidiot.gitbooks.io/leetcode-answer-java/content/valid_palindrome.html
public class ValidPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("abc"));
    }

    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }

        s = s.toLowerCase();

        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            while (i < j && !((s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
                    || (s.charAt(i) >= '0' && s.charAt(i) <= '9'))) {
                i++;
            }

            while (i < j && !((s.charAt(j) >= 'a' && s.charAt(j) <= 'z')
                    || (s.charAt(j) >= '0' && s.charAt(j) <= '9'))) {
                j--;
            }

            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}