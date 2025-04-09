package Data_Structure_Algorithms_Topic_Wise_Questions.dynamic_programming.one_d;

import java.util.Arrays;

public class CoinChange {

    public static int getFewestCoins(int[] coins, int idx, int amount, int[][] dp) {
        if(idx >= coins.length || amount < 0) {
            return Integer.MAX_VALUE;
        }

        if(amount == 0) {
            return 0;
        }

        if(dp[idx][amount] != -1) {
            return dp[idx][amount];
        }

        int notTakeCoin = getFewestCoins(coins, idx+1, amount, dp);
        int takeCoin = Integer.MAX_VALUE;

        if(coins[idx] <= amount) {
            takeCoin = getFewestCoins(coins, idx, amount-coins[idx], dp);

            if(takeCoin != Integer.MAX_VALUE) {
                takeCoin += 1;
            }
        }
        return dp[idx][amount] = Math.min(notTakeCoin, takeCoin);
    }

    public static int coinChange(int[] coins, int amount) {
        if(amount == 0) {
            return 0;
        }

        int[][] dp = new int[coins.length+1][amount+1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int minCoins = getFewestCoins(coins, 0, amount, dp);
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2,5}, 11));
    }
}
