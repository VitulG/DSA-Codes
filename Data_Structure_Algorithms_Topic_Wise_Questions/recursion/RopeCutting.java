package Data_Structure_Algorithms_Topic_Wise_Questions.recursion;

import java.util.Arrays;

public class RopeCutting {

    public static int canCutIntoPieces(int n, int a, int b, int c, int[] dp) {
        if(n == 0) {
            return 0;
        }

        if(n < 0) {
            return Integer.MIN_VALUE;
        }

        if(dp[n] != -1) {
            return dp[n];
        }

        int cutByA = canCutIntoPieces(n-a, a, b, c, dp);
        int cutByB = canCutIntoPieces(n-b, a, b, c, dp);
        int cutByC = canCutIntoPieces(n-c, a, b, c, dp);

        int result =  Math.max(cutByA, Math.max(cutByB, cutByC));

        return dp[n] = (result == Integer.MIN_VALUE) ? -1 : result+1;
    }

    public static void main(String[] args) {
        int n = 9;
        int a = 2;
        int b = 2;
        int c = 2;

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        System.out.println(canCutIntoPieces(9, a, b, c, dp));
    }
}
