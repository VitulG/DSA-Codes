package Data_Structure_Algorithms_Topic_Wise_Questions.dynamic_programming.two_d;

import java.util.Arrays;

public class ZeroOneKnapsack {

    public static int getMaximumValue(int[] val, int[] weights, int idx, int capacity, int[][] dp) {
        if(idx >= val.length) {
            return 0;
        }

        if(capacity < 0) {
            return 0;
        }

        if(dp[idx][capacity] != -1) {
            return dp[idx][capacity];
        }

        int notTake = getMaximumValue(val, weights, idx+1, capacity, dp);
        int take    = 0;

        if(weights[idx] <= capacity) {
            take = val[idx] + getMaximumValue(val, weights, idx+1, capacity - weights[idx], dp);
        }

        return dp[idx][capacity] = Math.max(notTake, take);
    }

    public static int knapsack(int W, int[] val, int[] wt) {
        // code here
        if(val.length == 0) {
            return 0;
        }

        int[][] dp  = new int[val.length+1][W+1];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return getMaximumValue(val, wt, 0, W, dp);
    }

    public static void main(String[] args) {
        System.out.println(knapsack(5, new int[]{10,40,30,50}, new int[]{5,4,2,3}));
    }
}
