package Data_Structure_Algorithms_Topic_Wise_Questions.dynamic_programming.one_d;

import java.util.Arrays;

public class MinCostClimbingStairs {

    public static int getMinCost(int[] cost, int idx, int[] dp) {
        if(idx >= cost.length) {
            return 0;
        }

        if(idx == cost.length-1) {
            return cost[idx];
        }

        if(dp[idx] != -1) {
            return dp[idx];
        }

        return dp[idx] = Math.min(getMinCost(cost, idx+1, dp),
                getMinCost(cost, idx+2, dp)) + cost[idx];
    }

    public static int minCostClimbingStairs(int[] cost) {
        if(cost.length == 0) {
            return 0;
        }

        int[] dp = new int[cost.length];

        Arrays.fill(dp, -1);
        int minCostUsingFirstIndex = getMinCost(cost, 0, dp);

        //Arrays.fill(dp, -1);
        int minCostUsingSecondIndex = getMinCost(cost, 1, dp);

        return Math.min(minCostUsingFirstIndex, minCostUsingSecondIndex);
    }

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{10,15,20}));
    }
}
