package Data_Structure_Algorithms_Topic_Wise_Questions.dynamic_programming.one_d;

import java.util.Arrays;

public class ClimbingStairs {
    public static int getWays(int num, int[] dp) {
        if(num < 0) {
            return 0;
        }

        if(num == 0) {
            return 1;
        }

        if(dp[num] != -1) {
            return dp[num];
        }

        int climbByOne = getWays(num-1, dp);
        int climbByTwo = getWays(num-2, dp);

        return dp[num] = climbByOne + climbByTwo;
    }

    public static int climbStairs(int num) {
        if(num == 0) {
            return 0;
        }
        int[] dp = new int[num+1];
        Arrays.fill(dp, -1);

        return getWays(num, dp);
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}
