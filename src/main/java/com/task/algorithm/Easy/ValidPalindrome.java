package com.task.algorithm.Easy;

/**
 * @author invzbl3 on 12/4/2022
 * @project LeetCodeTask
 */

/*
    Algorithm description:
    ---------------------


 */

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