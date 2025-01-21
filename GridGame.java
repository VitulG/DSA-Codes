public class GridGame {

    public static long gridGame(int[][] grid) {
        int n = grid[0].length;

        // Compute prefix sum for the first row
        long[] prefixSum = new long[n];
        prefixSum[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + grid[0][i];
        }

        // Compute suffix sum for the second row
        long[] suffixSum = new long[n];
        suffixSum[n - 1] = grid[1][n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + grid[1][i];
        }

        // Find the minimum points the second robot can collect
        long minSecondRobotPoints = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            // Points remaining on the top row (grid[0]) after column i
            long pointsTop = (i + 1 < n) ? prefixSum[n - 1] - prefixSum[i] : 0;

            // Points remaining on the bottom row (grid[1]) before column i
            long pointsBottom = (i > 0) ? suffixSum[0] - suffixSum[i] : 0;

            // Max points the second robot can collect
            long secondRobotPoints = Math.max(pointsTop, pointsBottom);

            // Minimize the maximum points the second robot can collect
            minSecondRobotPoints = Math.min(minSecondRobotPoints, secondRobotPoints);
        }

        return minSecondRobotPoints;
    }

    public static void main(String[] args) {
        System.out.println(gridGame(new int[][]{
                {1,3,1,15},
                {1,3,3,1}
        }));
    }
}
