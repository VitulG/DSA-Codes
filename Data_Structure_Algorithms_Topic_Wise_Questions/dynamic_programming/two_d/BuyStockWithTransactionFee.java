package Data_Structure_Algorithms_Topic_Wise_Questions.dynamic_programming.two_d;

import java.util.Arrays;

public class BuyStockWithTransactionFee {

    /*
        Approach: - I have to choose a day in which I will buy a stock or not and sell a stock or not, so I have
                        choices. So over here we can apply recursive knapsack so we will definitely find the overlapping
                        subproblems so DP can be applied here.
                    TC -> O(n)
                    SC -> O(2n)
     */

    public static int getMaximumProfitWithTransactionFee(int[] arr, int idx, int fee, int status, int[][] dp) {
        if(idx >= arr.length) {
            return 0;
        }

        if(dp[idx][status] != -1) {
            return dp[idx][status];
        }

        int maxProfit;

        if(status == 0) {
            int buy  = -arr[idx] + getMaximumProfitWithTransactionFee(arr, idx+1, fee, 1, dp);
            int skip = getMaximumProfitWithTransactionFee(arr, idx+1, fee, 0, dp);
            maxProfit = Math.max(buy, skip);
        }else {
            int sell = arr[idx] - fee + getMaximumProfitWithTransactionFee(arr, idx+1, fee, 0, dp);
            int skip = getMaximumProfitWithTransactionFee(arr, idx+1, fee, 1, dp);
            maxProfit = Math.max(sell, skip);
        }
        return dp[idx][status] = maxProfit;
    }

    public static int maxProfit(int[] arr, int k) {
        if(arr.length == 0) {
            return 0;
        }

        int[][] dp = new int[arr.length+1][2];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return getMaximumProfitWithTransactionFee(arr, 0, k, 0, dp);
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{6, 1, 7, 2, 8, 4}, 2));
    }
}
