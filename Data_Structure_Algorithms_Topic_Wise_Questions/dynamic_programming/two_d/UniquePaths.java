package Data_Structure_Algorithms_Topic_Wise_Questions.dynamic_programming.two_d;

import java.util.Arrays;

public class UniquePaths {

    public static int getUniquePaths(int i, int j, int m, int n, int[][] dp) {
        if(i > m || j > n) {
            return 0;
        }

        if(i == m && j == n) {
            return 1;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int moveByDown = getUniquePaths(i+1, j, m, n, dp);
        int moveByRight = getUniquePaths(i, j+1, m, n, dp);


        return dp[i][j] = moveByDown + moveByRight;
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return getUniquePaths(0,0,m-1, n-1, dp);
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3,7));
    }
}
