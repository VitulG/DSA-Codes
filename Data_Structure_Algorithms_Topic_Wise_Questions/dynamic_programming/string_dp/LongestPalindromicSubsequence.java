package Data_Structure_Algorithms_Topic_Wise_Questions.dynamic_programming.string_dp;

import java.util.Arrays;

public class LongestPalindromicSubsequence {

    /*
        Approach:
            - We need to find the longest palindromic subsequence.
            - Use two pointers (i and j) to check characters from both ends.

            1. If str[i] == str[j], it contributes 2 to the length,
            and we recurse inward (i+1, j-1).

            2. If str[i] != str[j], we try both:
            - move i forward (i+1, j)
            - move j backward (i, j-1)
            and take the maximum result.

        This is a classic DP on choices problem.

        Time Complexity  -> O(n^2)
        Space Complexity -> O(n^2)   // due to 2D memoization table
    */

    public static int getLongestPalindromicSubsequence(String str, int sti, int eni, int[][] dp) {
        if(sti > eni) {
            return 0;
        }

        if(sti == eni) {
            return 1;
        }

        if(dp[sti][eni] != -1) {
            return dp[sti][eni];
        }

        if(str.charAt(sti) == str.charAt(eni)) {
            return dp[sti][eni] = 2 + getLongestPalindromicSubsequence(str, sti + 1, eni - 1, dp);
        }else {
            return dp[sti][eni] = Math.max(getLongestPalindromicSubsequence(str, sti+1, eni, dp),
                    getLongestPalindromicSubsequence(str, sti, eni-1, dp));
        }
    }

    public static int longestPalinSubseq(String s) {
        if(s.isEmpty()) {
            return 0;
        }

        int[][] dp = new int[s.length()+1][s.length()+1];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return getLongestPalindromicSubsequence(s, 0, s.length()-1, dp);
    }

    public static void main(String[] args) {
        System.out.println(longestPalinSubseq("bbabcbcab"));
    }
}
