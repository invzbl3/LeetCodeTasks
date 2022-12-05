package com.task.algorithm.Easy;

/**
 * @author invzbl3 on 12/3/2022
 * @project LeetCodeTask
 */

/*
    Algorithm description:
    ---------------------
    Write a function that takes an unsigned integer and return the number of '1' bits it has
    (also known as the Hamming weight).

    Example 1:

    Input: 00000000000000000000000000001011
    Output: 3
    Explanation: The input binary string 00000000000000000000000000001011 has a total of three ‘1’ bits.

    Example 2:

    Input: 00000000000000000000000010000000
    Output: 1
    Explanation: The input binary string 00000000000000000000000010000000 has a total of one ‘1’ bit.

    Example 3:

    Input: 11111111111111111111111111111101
    Output: 31
    Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one ‘1’ bits.
 */

// https://hackmd.io/@y56/rkL8ynylB
public class NumberOf1Bits {

    public static int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; ++i) {
            if (((n >>> i) & 1) == 1) {
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int c = -1;
        System.out.println(hammingWeight(c));
    }
}

// Java, moving mask, loop over

/*
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }
}
 */

// Java, right-shift of n, loop over

/*
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            n >>= 1;
        }
        return bits;
    }
}
 */

// Java, right-shift of n, until all zeros

/*
    It may end earlier than for(i=0~31), since all-zeros may occur before going to the last bit.

    public static int hammingWeight(int n) {
	int ones = 0;
    	while(n!=0) {
    		ones = ones + (n & 1);
    		n = n>>>1;
    	}
    	return ones;
}

// Java, Bit Magic, flip the rightmost 1

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) { // flip the rightmost `1` until  all bits are `0`
            sum++;
            n &= (n - 1); // n = n & (n-1)
        return sum;
    }
}

eliminate the rightmost 1

n & (n - 1) is the result of flipping the rightmost 1 of n.

n       = 110100
n-1     = 110011
n&(n-1) = 110000

Java, Bit Magic, flip the rightmost 1

bizzard usage of for-loop

public int hammingWeight(int n) {
    int count = 0;
    for (;n!=0;n = n & (n-1))
        count++;
    return count;
}

C, Bit Magic, flip the rightmost 1

int hammingWeight(uint32_t n) {
    int count = n ? 1 : 0;
    while(n &= (n-1)) count++;
    return count;
}
 */