package Data_Structure_Algorithms_Topic_Wise_Questions.dynamic_programming.two_d;

import java.util.Arrays;

public class UniqueBinarySearchTrees {

    public static int getUniqueBSTs(int num, int[] dp) {
        if(num <= 1) {
            return 1;
        }

        if(dp[num] != -1) {
            return dp[num];
        }

        int ans = 0;

        for(int i=1; i<=num; i++) {
            int left = getUniqueBSTs(i-1, dp);
            int right = getUniqueBSTs(num-i, dp);
            ans += (left * right);
        }
        return dp[num] = ans;
    }

    public static int numTrees(int num) {
        if(num <= 1) {
            return 1;
        }
        int[] dp = new int[num+1];
        Arrays.fill(dp, -1);

        return getUniqueBSTs(num, dp);
    }

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }
}
