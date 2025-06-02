package Data_Structure_Algorithms_Topic_Wise_Questions.dynamic_programming.knapsack_dp;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockII {

    public static int getMaximumProfit(int[] prices, int idx, int status, int[][] dp) {
        if(idx >= prices.length) {
            return 0;
        }

        if(dp[idx][status] != -1) {
            return dp[idx][status];
        }

        int maxProfit;

        if(status == 0) {
            int buy = -prices[idx] + getMaximumProfit(prices, idx+1, 1, dp);
            int skip = getMaximumProfit(prices, idx+1, 0, dp);
            maxProfit = Math.max(buy, skip);
        }else {
            int sell = prices[idx] + getMaximumProfit(prices, idx+1, 0, dp);
            int skip = getMaximumProfit(prices, idx+1, 1, dp);
            maxProfit = Math.max(sell, skip);
        }

        return dp[idx][status] = maxProfit;
    }

    public static int maxProfit(int[] prices) {
        if(prices.length == 0) {
            return 0;
        }

        int[][] dp = new int[prices.length+1][2];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return getMaximumProfit(prices, 0, 0, dp);
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
