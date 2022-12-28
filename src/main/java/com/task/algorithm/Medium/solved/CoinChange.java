package com.task.algorithm.Medium.solved;

import java.util.Arrays;

/**
 * 322. Coin Change
 * https://leetcode.com/problems/coin-change/
 *
 * You are given an integer array coins representing coins of different denominations and an integer amount
 * representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be
 * made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 * Example 1:
 *
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 *
 * Example 3:
 *
 * Input: coins = [1], amount = 0
 * Output: 0
 *
 * Constraints:
 *
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 2^31 - 1
 * 0 <= amount <= 10^4
 */
class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == (amount + 1) ? -1 : dp[amount];
    }
}

/*
public class CoinChange {

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1}, 1)); // 1
        System.out.println(coinChange(new int[]{1}, 2)); // 2
    }

    public static int coinChange(int[] coins, int sum) {
        if (sum == 0) {
            return 0;
        }

        if (sum < 0) {
            return Integer.MAX_VALUE;
        }

        int coinsValue = Integer.MAX_VALUE;
        for (int c : coins) {
            int result = coinChange(coins, sum - c);

            if (result != Integer.MAX_VALUE) {
                coinsValue = Integer.min(coinsValue, result + 1);
            }
        }
        return coinsValue;
    }
}*/