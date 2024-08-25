public class MinimumFallingPathSumI {

    public static int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];

        for(int i=0; i<cols; i++) {
            dp[0][i] = matrix[0][i];
        }

        for(int i=1; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                int first = Integer.MAX_VALUE;
                int second = Integer.MAX_VALUE;
                int third = Integer.MAX_VALUE;

                if(j > 0) {
                    first = dp[i-1][j-1];
                }
                second = dp[i-1][j];

                if(j < cols-1) {
                    third = dp[i-1][j+1];
                }

                dp[i][j] = Math.min(first, Math.min(second, third)) + matrix[i][j];

            }
        }
        
        int ans = Integer.MAX_VALUE;

        for(int i=0; i<cols; i++) {
            ans = Math.min(ans, dp[rows-1][i]);
        }

        return ans;

    }

    public static void main(String[] args) {
        System.out.println(minFallingPathSum(new int[][]{{2,1,3},{6,5,4},{7,8,9}}));
    }
}