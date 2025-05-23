package Data_Structure_Algorithms_Topic_Wise_Questions.dynamic_programming.string_dp;

import java.util.Arrays;

public class LongestCommonSubsequences {

    /*
         Approach:
            - Compare characters of both strings at current indices.
            - If characters match:
                → Include this character in LCS (add 1) and move diagonally (i-1, j-1).
            - If not:
                → Try both options:
                    a) Exclude current character from s1 (move i-1)
                    b) Exclude current character from s2 (move j-1)
                → Take the max of both results.

          This builds a recursive tree of overlapping subproblems, so we use memoization (DP) to store results.

         Time Complexity: O(s1.length * s2.length)
         Space Complexity: O(s1.length * s2.length)
     */

    public static int getLongestCommonSubsequenceLength(String s1, int len1, String s2, int len2, int[][] dp) {
        if(len1 < 0 || len2 < 0) {
            return 0;
        }

        if(dp[len1][len2] != -1) {
            return dp[len1][len2];
        }

        if(s1.charAt(len1) == s2.charAt(len2)) {
            return dp[len1][len2] = 1 + getLongestCommonSubsequenceLength(s1, len1-1, s2, len2-1, dp);
        }else {
            return dp[len1][len2] = Math.max(getLongestCommonSubsequenceLength(s1, len1-1, s2, len2, dp),
                    getLongestCommonSubsequenceLength(s1, len1, s2, len2-1, dp));
        }
    }

    public static int lcs(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        int[][] dp = new int[len1+1][len2+1];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return getLongestCommonSubsequenceLength(s1, len1-1, s2, len2-1, dp);
    }

    public static void main(String[] args) {
        System.out.println(lcs("abcdgh", "aedfhr"));
    }
}
