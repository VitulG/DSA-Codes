import java.util.Arrays;

public class StrangePrinterI {

    public static int minTurns(String str, int i, int j, int size, int[][] dp) {
        if(i == j) {
            return 1;
        }

        if(i > j) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int l = i + 1;

        while(l <= j && str.charAt(l) == str.charAt(i)) {
            l++;
        }

        if(l == j+1) {
            return 1;
        }

        int basic = 1 + minTurns(str, l, j, size, dp);
        int greedy = Integer.MAX_VALUE;

        for(int p = l; p <= j; p++) {
            if(str.charAt(p) == str.charAt(i)) {
                int currAns = minTurns(str, l, p-1, size, dp) + minTurns(str, p, j, size, dp);
                greedy = Math.min(greedy, currAns);
            }
        }
        return dp[i][j] = Math.min(basic, greedy);
    }

    public static int strangePrinter(String str) {
        if(str == null || str.isEmpty()) {
            return 0;
        }
        int size = str.length();
        int[][] dp = new int[101][101];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return minTurns(str, 0, size-1, size, dp);
    }

    public static void main(String[] args) {
        System.out.println(strangePrinter("aba"));
    }
    
}
