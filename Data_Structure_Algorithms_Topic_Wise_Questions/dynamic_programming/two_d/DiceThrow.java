package Data_Structure_Algorithms_Topic_Wise_Questions.dynamic_programming.two_d;

import java.util.Arrays;

public class DiceThrow {

    /*
        Approach:
            - Use recursion with memoization (top-down DP).
            - For each die, try all possible face values from 1 to 'faces'.
            - Reduce the problem to finding the number of ways to get (sum - face value) using (dices - 1) dice.
            - Use a 2D DP array (dices x sum) to memoize results and avoid recomputation.

    Base Cases:
            - If sum < 0 → no valid way (return 0).
            - If dices == 0 → return 1 only if sum == 0 (i.e., a valid complete way), else return 0.

    Time Complexity: O(faces * dices * sum)
            - For each of the (dices x sum) states, we try up to 'faces' options.

            Space Complexity: O(dices * sum)
            - For memoization table (DP array).
     */

    public static int getNumberOfWays(int faces, int dices, int sum, int[][] dp) {
        if(sum < 0) {
            return 0;
        }

        if(dices == 0) {
            return sum == 0 ? 1 : 0;
        }

        if(dp[dices][sum] != -1) {
            return dp[dices][sum];
        }

        int ways = 0;

        for(int num = 1; num <= faces; num++) {
            ways += getNumberOfWays(faces, dices-1, sum - num, dp);
        }

        return dp[dices][sum] = ways;
    }


    public static int noOfWays(int m, int n, int x) {
        int[][] dp = new int[n+1][x+1];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return getNumberOfWays(m, n, x, dp);
    }

    public static void main(String[] args) {
        System.out.println(noOfWays(2,3,6));
    }
}
