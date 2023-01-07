package com.task.algorithm.Hard.solved;

import java.util.LinkedList;

/**
 * 60. Permutation Sequence
 * https://leetcode.com/problems/permutation-sequence/
 *
 * The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 * Example 1:
 *
 * Input: n = 3, k = 3
 * Output: "213"
 *
 * Example 2:
 *
 * Input: n = 4, k = 9
 * Output: "2314"
 *
 * Example 3:
 *
 * Input: n = 3, k = 1
 * Output: "123"
 *
 * Constraints:
 *
 * * 1 <= n <= 9
 * * 1 <= k <= n!
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder(n);
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add((char) ('0' + i));
        }
        pp(n, k, list, sb);
        return sb.toString();
    }

    private void pp(int n, int k, LinkedList<Character> list, StringBuilder sb) {
        if (n == 1) {
            sb.append(list.get(0));
            return;
        }
        int s = 1;
        for (int i = 1; i < n; i++) {
            s = s * i;
        }
        int index = (k - 1) / s;
        sb.append(list.get(index));
        list.remove(index);
        if (k % s == 0) {
            pp(n - 1, k - (index * s), list, sb);
        } else {
            pp(n - 1, k % s, list, sb);
        }
    }

    public static void main(String[] args) {
        PermutationSequence getPermutation = new PermutationSequence();
        System.out.println(getPermutation.getPermutation(3, 6));
    }
}