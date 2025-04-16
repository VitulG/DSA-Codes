package Data_Structure_Algorithms_Topic_Wise_Questions.dynamic_programming.two_d;

import java.util.Arrays;

public class MinimumPathSum {

    public static int getMinPath(int[][] grid, int i, int j, int[][] dp) {
        if(i >= grid.length || j >= grid[0].length) {
            return Integer.MAX_VALUE;
        }

        if(i == grid.length-1 && j == grid[0].length-1) {
            return grid[i][j];
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int pathFromDown = getMinPath(grid, i+1, j, dp);
        int pathFromRight = getMinPath(grid, i, j+1, dp);

        return dp[i][j] = Math.min(pathFromDown, pathFromRight) + grid[i][j];
    }

    public static int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length+1][grid[0].length+1];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return getMinPath(grid, 0, 0, dp);
    }

    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        }));
    }
}
