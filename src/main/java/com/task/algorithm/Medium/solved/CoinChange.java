package com.task.algorithm.Medium.solved;

import java.util.Arrays;

/**
 * @author invzbl3 on 12/3/2022
 * @project LeetCodeTask
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