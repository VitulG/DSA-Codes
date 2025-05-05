package Data_Structure_Algorithms_Topic_Wise_Questions.dynamic_programming.two_d;

import java.util.Arrays;
import java.util.List;

public class Triangle {

    /*
        Approach is if I am on the position of ith on the current row, so I will go to either in i+1 row or
            i+1 row, j+1 col diagonally so we have choices so here we can apply DP on choices
                TC -> O(n*m), SC -> O(n*m)
     */

    public static int getMinimumSteps(List<List<Integer>> triangle, int row, int col, int[][] dp) {
        if(row >= triangle.size() || col >= triangle.get(row).size()) {
            return 0;
        }

        if(dp[row][col] != -1) {
            return dp[row][col];
        }

        int stepsByDown = getMinimumSteps(triangle, row+1, col, dp);
        int stepsByDiagonal = getMinimumSteps(triangle, row+1, col+1, dp);

        return dp[row][col] = Math.min(stepsByDown, stepsByDiagonal) + triangle.get(row).get(col);

    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.isEmpty()) {
            return 0;
        }

        int size = triangle.size();
        int[][] dp = new int[size+1][size+1];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return getMinimumSteps(triangle, 0, 0, dp);
    }

    public static void main(String[] args) {
        List<Integer> firstRow = List.of(2);
        List<Integer> secondRow = List.of(3,4);
        List<Integer> thirdRow = List.of(6,5,7);
        List<Integer> fourthRow = List.of(4,1,8,3);

        List<List<Integer>> triangle = List.of(firstRow, secondRow, thirdRow, fourthRow);

        System.out.println(minimumTotal(triangle));
    }
}
