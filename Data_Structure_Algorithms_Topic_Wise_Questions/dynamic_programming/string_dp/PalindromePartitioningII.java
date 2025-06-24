package Data_Structure_Algorithms_Topic_Wise_Questions.dynamic_programming.string_dp;

import java.util.Arrays;

public class PalindromePartitioningII {

    /*
        Goal:
            - Partition the string such that every substring is a palindrome.
            - Return the minimum number of cuts required to achieve this.

        Strategy:
            - Try all substrings starting at each index and recursively find the minimum cuts.
            - Use memoization to cache the result from each index to avoid recomputation.

        Time Complexity:
            - O(n^3) in the worst case (checking palindrome for each substring).
            - Can be optimized to O(n^2) with precomputed palindrome checks.

        Space Complexity:
            - O(n) for memoization (dp[] array)
*/


    public static boolean[][] buildPalindromeSubstringArray(String str) {
        int length = str.length();

        boolean[][] palindromes = new boolean[length][length];

        for(int end = 0; end < length; end++) {
            for(int start = 0; start <= end; start++) {
                if(str.charAt(end) == str.charAt(start)) {
                    if(end - start <= 2 || palindromes[start+1][end-1]) {
                        palindromes[start][end] = true;
                    }
                }
            }
        }
        return palindromes;
    }

    public static int getMinimumCut(String str, int idx, int[] dp, boolean[][] palindromes) {
        if(idx >= str.length()) {
            return 0;
        }

        if(dp[idx] != -1) {
            return dp[idx];
        }

        int minCuts = Integer.MAX_VALUE;

        for(int i=idx; i<str.length(); i++) {
            if(palindromes[idx][i]) {
                int currentCuts = 1 + getMinimumCut(str, i+1, dp, palindromes);
                minCuts = Math.min(minCuts, currentCuts);
            }
        }
        return dp[idx] = minCuts;
    }

    public static int minCut(String s) {
        if(s.isEmpty() || s.length() == 1) {
            return 0;
        }

        int[] dp = new int[s.length()+1];
        Arrays.fill(dp, -1);

        boolean[][] palindromes = buildPalindromeSubstringArray(s);

        return getMinimumCut(s, 0, dp, palindromes) - 1;
    }

    public static void main(String[] args) {
        System.out.println(minCut("abbab"));
    }
}
