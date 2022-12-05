package com.task.algorithm.Easy;

/**
 * @author invzbl3 on 12/3/2022
 * @project LeetCodeTask
 */
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