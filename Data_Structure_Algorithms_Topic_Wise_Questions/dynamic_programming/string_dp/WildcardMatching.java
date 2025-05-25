package Data_Structure_Algorithms_Topic_Wise_Questions.dynamic_programming.string_dp;

import java.util.Arrays;

public class WildcardMatching {

    /*
         Approach: Recursive Wildcard Matching (from the end of both strings)

                1. If both string and pattern are fully traversed (si < 0 and pi < 0), return true.
                   → Full match achieved.

                2. If pattern is exhausted (pi < 0) but string is not (si >= 0), return false.
                   → Remaining string has no pattern to match.

                3. If string is exhausted (si < 0) but pattern is not (pi >= 0):
                   → Check if the remaining pattern contains only '*'.
                   → If yes, return true (since '*' can match empty string), else false.

                4. If current characters match, or pattern has '?', move both pointers back (si - 1, pi - 1).

                5. If pattern has '*':
                   → Two choices:
                     a. Take '*' → match one character in string (move si - 1, keep pi)
                     b. Skip '*' → treat '*' as matching zero characters (keep si, move pi - 1)
                   → Return true if either path matches.

                Time Complexity: O(n * m)   // with memoization
                Space Complexity: O(n * m)  // due to memoization table
     */

    public static boolean checkWildcardMatching(String str, int si, String pat, int pi, int[][] dp) {
        if(pi < 0 && si < 0) {
            return true;
        }

        if(si >= 0 && pi < 0) {
            return false;
        }

        if(si < 0 && pi >= 0) {
            for(int k=pi; k >=0; k--) {
                if(pat.charAt(k) != '*') {
                    return false;
                }
            }
            return true;
        }

        if(dp[si][pi] != -1) {
            return dp[si][pi] == 1;
        }

        boolean result;

        if(str.charAt(si) == pat.charAt(pi) || pat.charAt(pi) == '?') {
            result = checkWildcardMatching(str, si-1, pat, pi-1, dp);
            dp[si][pi] = result ? 1 : 0;
            return result;
        }

        if(pat.charAt(pi) == '*') {
            boolean take = checkWildcardMatching(str, si-1, pat, pi, dp);
            boolean skip = checkWildcardMatching(str, si, pat, pi-1, dp);

            result = take || skip;
            dp[si][pi] = result ? 1 : 0;
            return result;
        }
        dp[si][pi] = 0;
        return false;
    }

    public static boolean isMatching(String s, String p) {
        int[][] dp = new int[s.length()+1][p.length()+1];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return checkWildcardMatching(s, s.length()-1, p, p.length()-1, dp);
    }

    public static void main(String[] args) {
        System.out.println(isMatching("aa","?*"));
    }
}
