package com.task.algorithm.Easy.solved;

/**
 * 9. Palindrome Number
 * https://leetcode.com/problems/palindrome-number/
 *
 * Given an integer x, return true if x is a
 * palindrome, and false otherwise.
 *
 * Example 1:
 *
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 *
 * Example 2:
 *
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 *
 * Example 3:
 *
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 * Constraints:
 *
 * -2^31 <= x <= 2^31 - 1
 *
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        boolean palindrome = isPalindrome(11);
        System.out.println("result="+palindrome);
    }

    public static boolean isPalindrome(int x) {
        boolean isPalindrome =false;
        int firstnum=x;
        long res=0;
        if(x<0){
            return isPalindrome;
        }
        while (x != 0){
            res =res*10 + x%10;
            x /=10;
        }
        int y = (int)res ==res? (int)res :0;
        if(firstnum == y){
            isPalindrome=true;
        }
        return isPalindrome;
    }
}