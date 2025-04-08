package Data_Structure_Algorithms_Topic_Wise_Questions.dynamic_programming.one_d;

import java.util.Arrays;

public class MaxSumWithoutAdjacents {

    public static int findMaximumSum(int[] arr, int idx, int[] dp) {
        if(idx >= arr.length) {
            return 0;
        }

        if(dp[idx] != -1) {
            return dp[idx];
        }

        int notTake = findMaximumSum(arr, idx+1, dp);
        int take = arr[idx] + findMaximumSum(arr, idx+2, dp);

        return dp[idx] = Math.max(notTake, take);
    }

    public static int findMaxSum(int[] arr) {
        if(arr.length == 0) {
            return 0;
        }
        int[] dp = new int[arr.length+1];
        Arrays.fill(dp, -1);

        return findMaximumSum(arr, 0, dp);
    }

    public static void main(String[] args) {
        System.out.println(findMaxSum(new int[]{5, 5, 10, 100, 10, 5}));
    }
}
