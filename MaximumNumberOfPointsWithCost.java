public class MaximumNumberOfPointsWithCost {
    
    public static long maxPoints(int[][] points) {
        if(points.length==0) {
            return 0L;
        }

        int rows = points.length;
        int cols = points[0].length;

        long[][] dp = new long[rows][cols];

        for(int col = 0; col < cols; col++) {
            dp[0][col] = points[0][col];
        }

        for(int i=1; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                long maxPoint = Integer.MIN_VALUE;
                for(int upper = 0; upper < cols; upper++) {
                    maxPoint = Math.max(maxPoint, points[i][j]+dp[i-1][upper]-Math.abs(j - upper));
                }
                dp[i][j] = maxPoint;
            }
        }

        long ans = 0L;

        for(int col = 0; col< cols; col++) {
            ans = Math.max(ans, dp[rows-1][col]);
        }

        return ans;    
    }
    
    public static void main(String[] args) {
        System.out.println(maxPoints(new int[][]{{1,5},{2,3},{4,2}}));
    }
}