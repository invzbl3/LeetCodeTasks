package com.task.algorithm.Easy.solved;

/*
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * You are given an array prices where prices[i] is the price of a given stock on the i-th day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a
 * different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any
 * profit, return 0.
 *
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price =
 * 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed
 * because you must buy before you sell.
 *
 * Example 2:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max
 * profit = 0.
 *
 * Constraints:
 *
 * 1 <= prices.length <= 10^5
 * 0 <= prices[i] <= 10^4
 */

/*
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
}*/

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if (null == prices || prices.length == 0) {
            return 0;
        }

        //  int currentProfit = 0;
        int maxProfit = 0;
        int startIndex = 0;
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[startIndex];
            //  System.out.println("profit:" +profit);
            if (profit < 0) {
                startIndex = i;
            } else {
                // profit > 0
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        //  maxProfit = Math.max(maxProfit, currentProfit);
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock instance = new BestTimeToBuyAndSellStock();
        int[] prices = {6, 1, 3, 2, 4, 7};
        System.out.println(instance.maxProfit(prices));
    }
}