package Data_Structure_Algorithms_Topic_Wise_Questions.dynamic_programming.two_d;

import java.util.Arrays;

public class DungeonGame {

    public static int getKnightMinHp(int[][] dungeon, int row, int col, int[][] dp) {
        if(row >= dungeon.length || col >= dungeon[0].length) {
            return Integer.MAX_VALUE;
        }

        if(row == dungeon.length-1 && col == dungeon[0].length-1) {
            return Math.max(1, 1 - dungeon[row][col]);
        }

        if(dp[row][col] != -1) {
            return dp[row][col];
        }

        int downRoom = getKnightMinHp(dungeon, row+1, col, dp);
        int rightRoom = getKnightMinHp(dungeon, row, col+1, dp);

        return dp[row][col] = Math.max(1, Math.min(downRoom, rightRoom) - dungeon[row][col]);
    }

    public static int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length+1][dungeon[0].length+1];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return getKnightMinHp(dungeon, 0, 0, dp);
    }

    public static void main(String[] args) {
        System.out.println(calculateMinimumHP(new int[][]{
                {-2,-3,3},
                {-5,-10,1},
                {10,30,-5}
        }));
    }
}
