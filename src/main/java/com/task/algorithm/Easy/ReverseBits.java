package com.task.algorithm.Easy;

/**
 * @author invzbl3 on 12/3/2022
 * @project LeetCodeTask
 */

/*
    Algorithm description:
    ---------------------
    Reverse bits of a given 32 bits unsigned integer.

    Note:

    - Note that in some languages, such as Java, there is no unsigned integer type.
      In this case, both input and output will be given as a signed integer type.
      They should not affect your implementation, as the integer's internal binary representation is the same,
      whether it is signed or unsigned.

    - In Java, the compiler represents the signed integers using 2's complement notation.
      Therefore, in Example 2 above, the input represents the signed integer -3 and the output represents
      the signed integer -1073741825.
 */

// https://leetcode.com/problems/reverse-bits/

public class Solution {
    public static int  reverseBits(int n) {
        int rval = 0x0;
        for (int i = 0; i < 32; i ++) {
            if ( ((1 << i) & n) != 0) {
                rval |= 1 << (31 - i);
            }
        }
        return rval;
    }

    public static void main(String[] args) {
        int n = 43261596;

        System.out.println(reverseBits(n));  // 964176192
    }
}

/*
public class ReverseBits {
    public static int reverseBits(int n) {
        int rev_input = 0;

        while (n > 0) {
            rev_input <<= 1;
            if ((n & 1) == 1) {
                rev_input ^= 1;
            }
            n >>= 1;
        }
        return rev_input;
    }

    public static void main(String[] args) {
        int input = 13;
        System.out.println("Reverse actual bits of the given number");
        System.out.println(reverseBits(input));
    }
}*/