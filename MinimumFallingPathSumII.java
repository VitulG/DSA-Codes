import java.util.Arrays;

public class MinimumFallingPathSumII {

    public static int getMinPath(int[][] grid, int row, int col, int[][] dp) {
        if(row == grid.length-1) {
            return grid[row][col];
        }

        if(dp[row][col] != -1) {
            return dp[row][col];
        }

        int ans = Integer.MAX_VALUE;

        for(int nextCol = 0; nextCol < grid[row].length; nextCol++) {
            if(nextCol != col) {
                ans = Math.min(ans, getMinPath(grid, row+1, nextCol, dp));
            }
        }
        return dp[row][col] = ans + grid[row][col];

    }

    public static int minFallingPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = Integer.MAX_VALUE;

        for(int col = 0; col < cols; col++){
            ans = Math.min(ans, getMinPath(grid, 0, col, dp));
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(minFallingPathSum(new int[][]{{-73,61,43,-48,-36},{3,30,27,57,10},{96,-76,84,59,-15},{5,-49,76,31,-7},{97,91,61,-46,67}}));
    }
}
