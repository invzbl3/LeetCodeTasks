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
public class ReverseBits {
    public static int reverseBinaryBits(int input){
        int rev_input = 0;

        while (input > 0){
            rev_input <<= 1;
            if ((input & 1) == 1){
                rev_input ^= 1;
            }
            input >>= 1;
        }
        return rev_input;
    }

    public static void main(String[] args){
        int input = 13;
        System.out.println("Reverse actual bits of the given number");
        System.out.println(reverseBinaryBits(input));
    }
}