import java.util.Arrays;

public class MinimumNumberOfDeletionsToMakeAStringPalindrome {

    public static int getLongestPalindromicSubsequence(String original, int i, String reversed, int j, int[][] dp) {
        if(i >= original.length() || j >= reversed.length()) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int result = 0;

        if(original.charAt(i) == reversed.charAt(j)) {
            result += getLongestPalindromicSubsequence(original, i+1, reversed, j+1, dp) + 1;
        }else {
            int indexMovedInOriginal = getLongestPalindromicSubsequence(original, i+1, reversed, j, dp);
            int indexMovedInReversed = getLongestPalindromicSubsequence(original, i, reversed, j+1, dp);

            result += Math.max(indexMovedInOriginal, indexMovedInReversed);
        }
        return dp[i][j] = result;
    }

    public static int minInsertions(String str) {
        if(str.isEmpty()) {
            return 0;
        }

        StringBuilder reverseString = new StringBuilder(str);
        reverseString.reverse();

        int[][] dp = new int[501][501];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int lpsLength = getLongestPalindromicSubsequence(str, 0, reverseString.toString(), 0, dp);

        return str.length() - lpsLength;
    }

    public static void main(String[] args) {
        System.out.println(minInsertions("leetcode"));
    }
}
