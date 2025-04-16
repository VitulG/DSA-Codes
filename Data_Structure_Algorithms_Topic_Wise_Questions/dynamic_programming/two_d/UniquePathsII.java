package Data_Structure_Algorithms_Topic_Wise_Questions.dynamic_programming.two_d;

import java.util.Arrays;

public class UniquePathsII {

    public static int getUniquePaths(int[][] obstacleGrid, int i, int j, int[][] dp) {
        if(i >= obstacleGrid.length || j >= obstacleGrid[0].length || obstacleGrid[i][j] == 1) {
            return 0;
        }

        if(i == obstacleGrid.length-1 && j == obstacleGrid[0].length-1) {
            return 1;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int moveByDown = getUniquePaths(obstacleGrid, i+1, j, dp);
        int moveByRight = getUniquePaths(obstacleGrid, i, j+1, dp);

        return dp[i][j] = moveByDown + moveByRight;

    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length+1][obstacleGrid[0].length+1];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return getUniquePaths(obstacleGrid, 0, 0, dp);
    }

    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{
                {0,0,0},
                {0,1,0},
                {0,0,0}
        }));
    }
}
