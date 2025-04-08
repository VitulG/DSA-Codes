package Data_Structure_Algorithms_Topic_Wise_Questions.dynamic_programming.one_d;

import java.util.Arrays;

public class PerfectSquares {

    public static int getNumberOfPerfectSquare(int num, int[] dp) {
        if(num <= 0) {
            return 0;
        }

        if(dp[num] != -1) {
            return dp[num];
        }

        int result = Integer.MAX_VALUE;

        for(int i=1; i*i<=num; i++) {
            result = Math.min(result, getNumberOfPerfectSquare(num-i*i, dp));
        }
        return dp[num] = result+1;
    }

    public static int numSquares(int n) {
        if(n <= 1) {
            return n;
        }
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return getNumberOfPerfectSquare(n, dp);
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
}
