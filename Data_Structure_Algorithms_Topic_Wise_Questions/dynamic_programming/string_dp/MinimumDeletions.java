package Data_Structure_Algorithms_Topic_Wise_Questions.dynamic_programming.string_dp;

import java.util.Arrays;

public class MinimumDeletions {

    /*
        Approach: -
            - The minimum number of deletions to make a string a palindrome is:
                total length - length of longest palindromic subsequence (LPS)
                - So if we find LPS(s), then min deletions = s.length() - LPS
                - We use top-down DP with memoization to compute LPS.

            Time Complexity: O(n^2)
            Space Complexity: O(n^2)
     */

    public static int getLongestPalindromicSubsequence(String str, int st, int en, int[][] dp) {
        if(st > en) {
            return 0;
        }

        if(st == en) {
            return 1;
        }

        if(dp[st][en] != -1) {
            return dp[st][en];
        }

        if(str.charAt(st) == str.charAt(en)) {
            return dp[st][en] = 2 + getLongestPalindromicSubsequence(str, st+1, en-1, dp);
        }else {
            return dp[st][en] = Math.max(getLongestPalindromicSubsequence(str, st+1, en, dp),
                    getLongestPalindromicSubsequence(str, st, en-1, dp));
        }

    }

    public static int minDeletions(String s) {
        if(s.isEmpty()) {
            return 0;
        }
        int[][] dp = new int[s.length()+1][s.length()+1];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int lps = getLongestPalindromicSubsequence(s, 0, s.length()-1, dp);

        return s.length() - lps;
    }

    public static void main(String[] args) {
        System.out.println(minDeletions("aebcbda"));
    }
}
