package Data_Structure_Algorithms_Topic_Wise_Questions.dynamic_programming.string_dp;

import java.util.Arrays;

public class EditDistance {

    /*
        Approach: -
                    1. If characters at current positions match, move both pointers ahead (no operation needed).
                    2. If characters don't match, we have 3 options:
                        a. Insert  → Add word2[j] to word1, so move pointer j ahead (i stays).
                        b. Delete  → Remove word1[i], so move pointer i ahead (j stays).
                        c. Replace → Replace word1[i] with word2[j], so move both i and j ahead.
                    3. For each option, add 1 operation cost and recur.
                    4. Use memoization (DP) to store intermediate results and avoid recomputation.
                    5. Base cases handle remaining unmatched characters in either string.

                Time Complexity:  O(n * m)  → n = length of word1, m = length of word2
                Space Complexity: O(n * m)  → for DP array
     */

    public static int getMinimumOperations(String word1, int i, String word2, int j, int[][] dp) {
        if(i >= word1.length()) {
            return word2.length() - j; // no. of insertion required
        }

        if(j >= word2.length()) {
            return word1.length() - i; // no. of insertion required
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        if(word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = getMinimumOperations(word1, i+1, word2, j+1, dp);
        }else {
            int insert = 1 + getMinimumOperations(word1, i, word2, j+1, dp);
            int delete = 1 + getMinimumOperations(word1, i+1, word2, j, dp);
            int replace = 1 + getMinimumOperations(word1, i+1, word2, j+1, dp);

            return dp[i][j] = Math.min(insert, Math.min(delete, replace));
        }
    }

    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return getMinimumOperations(word1, 0, word2, 0, dp);
    }

    public static void main(String[] args) {
        System.out.println(minDistance("intention", "execution"));
    }
}
