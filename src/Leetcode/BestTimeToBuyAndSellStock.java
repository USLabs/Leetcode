package Leetcode;

/**
 * Created by uslabs on 10/29/17.
 */

/*
    Because buy and sell prices may not be the same, when k>len/2, that means we can do as many transactions as we want.
    So, in case k>len/2, this problem is same to Best Time to Buy and Sell Stock III.
    t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax) gives us the maximum price when we sell at this price;
    tmpMax = Math.max(tmpMax, t[i - 1][j] - prices[j]) gives us the value when we buy at this price and leave this value for prices[j+1].
*/

public class BestTimeToBuyAndSellStock {
    public static void solution() {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int k = 2;
        System.out.println(maxProfit(k, prices));
    }

    public static int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) return quickSolve(prices);

        int[][] t = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            int tmpMax =  -prices[0];
            for (int j = 1; j < len; j++) {
                t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax);
                tmpMax =  Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);
            }
        }
        return t[k][len - 1];
    }


    private static int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
}
