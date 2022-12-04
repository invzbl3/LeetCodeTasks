package com.task.algorithm;

/**
 * @author invzbl3 on 12/3/2022
 * @project LeetCodeTask
 */
public class CoinChange {

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1}, 1)); // 1
        System.out.println(coinChange(new int[]{1}, 2)); // 2
    }

    public static int coinChange(int[] S, int sum) {
        if (sum == 0) {
            return 0;
        }
        if (sum < 0) {
            return Integer.MAX_VALUE;
        }
        int coins = Integer.MAX_VALUE;
        for (int c : S) {
            int result = coinChange(S, sum - c);

            if (result != Integer.MAX_VALUE) {
                coins = Integer.min(coins, result + 1);
            }
        }
        return coins;
    }
}