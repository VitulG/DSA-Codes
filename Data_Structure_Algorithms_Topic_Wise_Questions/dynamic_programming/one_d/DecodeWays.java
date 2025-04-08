package Data_Structure_Algorithms_Topic_Wise_Questions.dynamic_programming.one_d;

import java.util.Arrays;

public class DecodeWays {

    public static int getDecodingWays(String str, int idx, int[] dp) {
        if(idx >= str.length()) {
            return 1;
        }

        if(str.charAt(idx) == '0') {
            return 0;
        }

        if(dp[idx] != -1) {
            return dp[idx];
        }

        int first = getDecodingWays(str, idx+1, dp);

        int second = 0;

        if(idx < str.length()-1) {
            String sub = str.substring(idx, idx+2);
            int value = Integer.parseInt(sub);

            if(value >= 10 && value <= 26) {
                second = getDecodingWays(str, idx+2, dp);
            }

        }
        return dp[idx] = first + second;
    }

    public static int numDecodings(String str) {
        if(str.isEmpty() || str.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[str.length()+1];
        Arrays.fill(dp, -1);

        return getDecodingWays(str, 0, dp);
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("226"));
    }
}
