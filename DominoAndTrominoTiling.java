import java.util.Arrays;

public class DominoAndTrominoTiling {

    public static int getNumberOfWays(int num, int MOD, int[] dp) {
        if(num <= 2) {
            return num;
        }

        if(num == 3) {
            return 5;
        }

        if(dp[num] != -1) {
            return dp[num];
        }

        return dp[num] = ((getNumberOfWays(num-1, MOD, dp) * 2)%MOD +
                getNumberOfWays(num-3, MOD, dp))%MOD;
    }

    public static int numTilings(int n) {
        if(n <= 2) {
            return n;
        }
        int MOD = 1000000007;

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return getNumberOfWays(n, MOD, dp);
    }

    public static void main(String[] args) {
        System.out.println(numTilings(7));
    }
}
