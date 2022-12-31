package com.task.algorithm.Medium.solved;

/**
 * 7. Reverse Integer
 * https://leetcode.com/problems/reverse-integer/
 *
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside
 * the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *
 * Example 1:
 *
 * Input: x = 123
 * Output: 321
 *
 * Example 2:
 *
 * Input: x = -123
 * Output: -321
 *
 * Example 3:
 *
 * Input: x = 120
 * Output: 21
 *
 * Constraints:
 *
 * -2^31 <= x <= 2^31 - 1
 */
public class ReverseInteger {

    static final int[] table = {9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};
    static final char[] MAX = {'2', '1', '4', '7', '4', '8', '3', '6', '4', '7'};

    public int reverse(int x) {

        if (x == 0) return 0;
        if (x == Integer.MIN_VALUE) return 0;
        int y = Math.abs(x);
        int res = 0;
        int i = 0;
        int size = 0;
        for (; ; i++) {
            if (y <= table[i]) {
                size = i + 1;
                break;
            }
        }
        char[] chars = null;
        if (size == MAX.length) {
            chars = new char[size];
        }
        i = 0;
        int t = 0;
        while (y != 0) {
            t = y % 10;
            res = res * 10 + t;
            y = y / 10;
            if (size == MAX.length) {
                chars[i] = (char) (t + '0');
                i++;
            }
        }
        if (size < MAX.length) {
            return x < 0 ? -res : res;
        }


        for (i = 0; i < MAX.length; i++) {

            if (chars[i] > MAX[i]) {
                return 0;
            } else if (chars[i] == MAX[i]) {
                continue;
            } else {
                return x < 0 ? -res : res;
            }
        }

        return 0;
    }

    /*public int reverse(int x) {
        long n = 0;
        while(x != 0) {
            n = n*10 + x%10;
            x = x/10;
        }
        return (int)n==n? (int)n:0;
    }*/

    public static void main(String[] args) {
        //System.out.println(Integer.MAX_VALUE);
        //System.out.println(Integer.MIN_VALUE);
        /*System.out.println(new Solution().reverse(0));
        System.out.println(new Solution().reverse(123456789));
        System.out.println(new Solution().reverse(1234567899));
        System.out.println(new Solution().reverse(-1234567899));
        System.out.println(new Solution().reverse(-2147483412));
        System.out.println(new Solution().reverse(Integer.MIN_VALUE));
        System.out.println(new Solution().reverse(Integer.MAX_VALUE));*/
        System.out.println(new ReverseInteger().reverse(1534236469));
    }
}