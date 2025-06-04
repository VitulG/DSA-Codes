package Data_Structure_Algorithms_Topic_Wise_Questions.dynamic_programming.string_dp;

import java.util.Arrays;

public class LCSOfThreeStrings {

    /*
        Problem: Find the length of the Longest Common Subsequence among 3 strings.

        Approach:
        - Use a recursive + memoization (Top-Down DP) strategy.
        - At each recursive call, compare characters at i (from s1), j (from s2), and k (from s3).
            1. If all three characters match, we've found part of a common subsequence.
               So, move all pointers forward and add 1 to the result.
            2. Else, explore all 3 possibilities:
               - Move i forward
               - Move j forward
               - Move k forward
               Take the maximum of these three recursive calls.

        Time Complexity: O(n * m * o)
        Space Complexity: O(n * m * o), where:
            n = length of s1
            m = length of s2
            o = length of s3
    */

    public static int getLcsOf3(String s1, int i, String s2, int j, String s3, int k, int[][][] dp) {
        if(i >= s1.length() || j >= s2.length() || k >= s3.length()) {
            return 0;
        }

        if(dp[i][j][k] != -1) {
            return dp[i][j][k];
        }

        if(s1.charAt(i) == s2.charAt(j) && s2.charAt(j) == s3.charAt(k)) {
            return dp[i][j][k] = 1 + getLcsOf3(s1, i+1, s2, j+1, s3, k+1, dp);
        }else {
            int first = getLcsOf3(s1, i+1, s2, j, s3, k, dp);
            int second = getLcsOf3(s1, i, s2, j+1, s3, k, dp);
            int third = getLcsOf3(s1, i, s2, j, s3, k+1, dp);

            return dp[i][j][k] = Math.max(first, Math.max(second, third));
        }

    }

    public static int lcsOf3(String s1, String s2, String s3) {
        int[][][] dp = new int[s1.length()+1][s2.length()+1][s3.length()+1];

        for(int[][] mat : dp) {
            for(int[] row : mat) {
                Arrays.fill(row, -1);
            }
        }

        return getLcsOf3(s1, 0, s2, 0, s3, 0, dp);
    }

    public static void main(String[] args) {
        System.out.println(lcsOf3("abcd1e2", "bc12ea", "bd1ea"));
    }
}
