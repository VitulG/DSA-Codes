import java.util.Arrays;

public class NumberOfWaysToFormATargetStringGivenADictionary {

    private static long ways(String target, int ti, int[][] preprocessWordsFreq, int pi, int MOD, int[][] dp) {
        if(ti >= target.length()) {
            return 1;
        }

        if(pi >= preprocessWordsFreq.length) {
            return 0;
        }

        if(dp[ti][pi] != -1) {
            return dp[ti][pi];
        }

        int skipWordChar = (int)(ways(target, ti, preprocessWordsFreq, pi+1, MOD, dp) % MOD);

        int takeWordChar = 0;
        char currentChar = target.charAt(ti);

        if(preprocessWordsFreq[pi][currentChar-'a'] > 0) {
            takeWordChar = (int) ((preprocessWordsFreq[pi][currentChar-'a'] *
                                ways(target, ti+1, preprocessWordsFreq, pi+1, MOD, dp))%MOD);
        }
        return dp[ti][pi] = (skipWordChar + takeWordChar) % MOD;
    }

    public static int numWays(String[] words, String target) {
        // preprocess the freq for each word
        int[][] preprocessWordsFreq = new int[words[0].length()][26];
        int MOD = 1000000007;

        for(String word : words) {
            for(int row= 0; row<words[0].length(); row++) {
                preprocessWordsFreq[row][word.charAt(row) - 'a']++;
            }
        }

        int[][] dp = new int[1001][1001];

        for(int[] r : dp) {
            Arrays.fill(r, -1);
        }

        return (int) (ways(target, 0, preprocessWordsFreq, 0, MOD, dp)%MOD);
    }

    public static void main(String[] args) {
        System.out.println(numWays(new String[]{"acca","bbbb","caca"}, "aba"));
    }
}
