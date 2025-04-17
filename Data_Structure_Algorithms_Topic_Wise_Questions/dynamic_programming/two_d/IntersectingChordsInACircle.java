package Data_Structure_Algorithms_Topic_Wise_Questions.dynamic_programming.two_d;

import java.util.Arrays;

public class IntersectingChordsInACircle {

    public static long getUniqueChords(int A, long[] dp) {
        if(A <= 1) {
            return 1;
        }

        if(dp[A] != -1) {
            return dp[A];
        }

        long ans = 0L;

        for(int i=1; i<=A; i++) {
            long left = getUniqueChords(i-1, dp);
            long right = getUniqueChords(A-i, dp);

            ans = (ans + ((left * right) % 1000000007)) % 1000000007;
        }
        return dp[A] = ans;
    }

    public static int chordCnt(int A) {
        if(A <= 1) {
            return 1;
        }

        long[] dp = new long[A+1];
        Arrays.fill(dp, -1);

        long ans =  getUniqueChords(A, dp);

        ans %= 1000000007;

        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(chordCnt(7));
    }
}
