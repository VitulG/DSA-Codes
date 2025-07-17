package Data_Structure_Algorithms_Topic_Wise_Questions.dynamic_programming.one_d;

import java.util.Arrays;

public class CuttingBinaryString {

    /*
        Approach: -  to solve this question we need to make partitions we will be start doing partitions from the left
                        1. start from 0 and take every substring just like brute-force and check if the substring is a
                             valid for square of 5 if yes we found a partition or else move to the next partition and so
                             on.

                     TC -> O(n^3)
                     SC -> O(n)
     */

    public static boolean isValidBinarySubstring(String str) {
        if(str.charAt(0) == '0') {
            return false;
        }

        int value = 0;
        int pow = 0;
        int idx = str.length()-1;

        while (idx >= 0) {
            int digit = str.charAt(idx) - '0';
            value += digit << pow;
            idx--;
            pow++;
        }

        int powOfFive = 1;

        while(powOfFive <= value) {
            if(powOfFive == value) {
                return true;
            }
            powOfFive *= 5;
        }
        return false;
    }

    public static int getMinimumCuts(String s, int idx, int[] dp) {
        if(idx >= s.length()) {
            return 0;
        }

        if(dp[idx] != -1) {
            return dp[idx];
        }

        int minCuts = Integer.MAX_VALUE;

        for(int i=idx; i<s.length(); i++) {
            String binarySubstring = s.substring(idx, i+1);

            if(isValidBinarySubstring(binarySubstring)) {
                int currentCuts = getMinimumCuts(s, i+1, dp);

                if(currentCuts != -1) {
                    minCuts = Math.min(minCuts, 1 + currentCuts);
                }
            }
        }
        return minCuts == Integer.MAX_VALUE ? -1 : minCuts;
    }

    public static int cuts(String s) {
        if(s.isEmpty()) {
            return -1;
        }

        int[] dp = new int[s.length()+1];
        Arrays.fill(dp, -1);

        return getMinimumCuts(s, 0, dp);
    }

    public static void main(String[] args) {
        System.out.println(cuts("1111101"));
    }
}
