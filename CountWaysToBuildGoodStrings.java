import java.util.Arrays;

public class CountWaysToBuildGoodStrings {

    // dp code TC => O(high)
    public static int getGoodStrings(int currLen, int lo, int hi, int zero, int one, int[] dp, int MOD) {
        if(currLen > hi) {
            return 0;
        }

        if(dp[currLen] != -1) {
            return dp[currLen];
        }

        int count = (currLen >= lo) ? 1 : 0;

        count = (count + getGoodStrings(currLen+zero, lo, hi, zero, one, dp, MOD))%MOD;
        count = (count + getGoodStrings(currLen+one, lo, hi, zero, one, dp, MOD))%MOD;

        return dp[currLen] = count;
    }

    public static int countGoodStrings(int low, int high, int zero, int one) {
        int MOD = 1000000007;

        int[] dp = new int[high+1];

        Arrays.fill(dp, -1);

        return getGoodStrings(0, low, high, zero, one, dp, MOD);
    }

    // using Backtracking we will get TLE. with TC => O(2^(high/min(zero, one)))
    public static void backtrack(int lo, int hi, StringBuilder zero, StringBuilder one, StringBuilder currString,
                                 int[] ans) {
        if(currString.length() > hi) {
            return;
        }

        if(currString.length() >= lo) {
            ans[0]++;
        }

        currString.append(zero);
        backtrack(lo, hi, zero, one, currString, ans);
        currString.delete(currString.length()-zero.length(), currString.length());
        currString.append(one);
        backtrack(lo, hi, zero, one, currString, ans);
        currString.delete(currString.length()-one.length(), currString.length());

    }

    public int countGoodStringsUsingBackTracking(int low, int high, int zero, int one) {
        StringBuilder zeroString = new StringBuilder();
        zeroString.append("0".repeat(Math.max(0, zero)));

        StringBuilder oneString = new StringBuilder();
        oneString.append("1".repeat(Math.max(0, one)));

        int[] ans = {0};

        backtrack(low, high, zeroString, oneString, new StringBuilder(), ans);

        return ans[0];
    }


    public static void main(String[] args) {
        System.out.println(countGoodStrings(2,3,1,2));
    }
}
