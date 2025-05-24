package Data_Structure_Algorithms_Topic_Wise_Questions.dynamic_programming.string_dp;

import java.util.Arrays;

public class RegularExpressionMatching {

    /*
        Approach to check regular expression matching:
            1. Check if the current characters match — also handle '.' wildcard,
               which can match any single character.

            2. If the next pattern character (pi + 1) is '*', we have two choices:
               - **Skip** the current `char*` (i.e., consider zero occurrences), and move to pi + 2.
               - **Take** the current pattern if the current characters match (including '.'), and advance si only.

            3. If there is no '*', perform a normal match check (exact character or '.'), and move both si and pi forward.

            Time Complexity: O(n * m)  // with memoization or DP
            Space Complexity: O(n * m) // for memo table or dp[][] array
     */

    public static boolean checkRegularExpression(String str, int si, String pat, int pi, int[][] dp) {
        if(pi >= pat.length()) {
            return si >= str.length();
        }

        if(dp[si][pi] != -1) {
            return dp[si][pi] == 1;
        }

        boolean hasCharacterMatched = (si < str.length()) && (str.charAt(si) == pat.charAt(pi) ||
                pat.charAt(pi) == '.');

        boolean result;

        if(pi + 1 < pat.length() && pat.charAt(pi+1) == '*') {
            boolean take = hasCharacterMatched && checkRegularExpression(str, si+1, pat, pi, dp);
            boolean skip = checkRegularExpression(str, si, pat, pi+2, dp);

            result = take || skip;
        }else {
            result = hasCharacterMatched && checkRegularExpression(str, si+1, pat, pi+1, dp);
        }
        dp[si][pi] = result ? 1 : 0;
        return result;
    }

    public static boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length()+1][p.length()+1];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return checkRegularExpression(s, 0, p, 0, dp);
    }

    public static void main(String[] args) {
        System.out.println(isMatch("ab", ".*"));
    }
}
