package com.task.algorithm.Easy;

/**
 * @author invzbl3 on 12/3/2022
 * @project LeetCodeTask
 */

/*
    Algorithm description:
    ---------------------
    You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
    On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the
    stock at any time. However, you can buy it then immediately sell it on the same day.
    Find and return the maximum profit you can achieve.

    Input: prices = [7, 1, 5, 3, 6, 4]
    Output: 7

    Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.

    Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
    Total profit is 4 + 3 = 7.
 */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        System.out.println(bestTimeToBuyAndSellStock.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        int wtb = 0;
        int wts;
        boolean readyToSell = false;
        for (int i = 0; i < prices.length - 1; i++) {
            if ((prices[i + 1] > prices[i]) && !readyToSell) {
                wtb = prices[i];
                readyToSell = true;
            }
            if ((prices[i + 1] < prices[i]) && readyToSell) {
                wts = prices[i];
                profit = profit + wts - wtb;
                readyToSell = false;
            }
            if (i == prices.length - 2 && readyToSell) {
                wts = prices[prices.length - 1];
                profit = profit + wts - wtb;
                readyToSell = false;
            }
        }
        return profit;
    }
}