package Data_Structure_Algorithms_Topic_Wise_Questions.dynamic_programming.two_d;

import java.util.Arrays;

public class MaximalSquare {

    /*
        The key approach is to get the min square from the right, diagonal, and down side
        agar jis position pe hu waha 1 hai to mujhe dekhna hoga ki minimum kitne 1 hai jisse main ek square formed kar
        sakta hu uska from right, diagonal aur down side se + 1 wo bhi 1 hai

        TC -> O(n*m), SC -> O(n * m)

     */

    public static int getMaximumSquare(char[][] matrix, int row, int col, int rows, int cols, int[] maxSize, int[][] dp) {
        if(row >= rows || col >= cols) {
            return 0;
        }

        if(dp[row][col] != -1) {
            return dp[row][col];
        }

        int right = getMaximumSquare(matrix, row, col+1, rows, cols, maxSize, dp);
        int diagonal = getMaximumSquare(matrix, row+1, col+1, rows, cols, maxSize, dp);
        int down = getMaximumSquare(matrix, row+1, col, rows, cols, maxSize, dp);

        if(matrix[row][col] == '0') {
            return dp[row][col] = 0;
        }else {
            int ans = 1 + Math.min(right, Math.min(diagonal, down));
            maxSize[0] = Math.max(maxSize[0], ans);
            return dp[row][col] = ans;
        }
    }

    public static int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] maxSize = {Integer.MIN_VALUE};

        int[][] dp = new int[rows+1][cols+1];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        getMaximumSquare(matrix, 0, 0, rows, cols, maxSize, dp);

        return maxSize[0] * maxSize[0];
    }

    public static void main(String[] args) {
        System.out.println(maximalSquare(new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        }));
    }
}
