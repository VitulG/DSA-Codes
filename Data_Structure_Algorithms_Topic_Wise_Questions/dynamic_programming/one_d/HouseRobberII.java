package Data_Structure_Algorithms_Topic_Wise_Questions.dynamic_programming.one_d;

import java.util.Arrays;

public class HouseRobberII {

    public static int getMaximumAmount(int[] nums, int idx, int last, int[] dp) {
        if(idx >= last) {
            return 0;
        }

        if(dp[idx] != -1) {
            return dp[idx];
        }
        int notTake = getMaximumAmount(nums, idx+1, last, dp);
        int take = nums[idx] + getMaximumAmount(nums, idx+2, last, dp);
        return dp[idx] = Math.max(notTake, take);
    }

    public static int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length+1];

        Arrays.fill(dp, -1);
        int robFromFirstHouse = getMaximumAmount(nums, 0, nums.length-1, dp);

        Arrays.fill(dp, -1);
        int robFromSecondHouse = getMaximumAmount(nums, 1, nums.length, dp);

        return Math.max(robFromFirstHouse, robFromSecondHouse);
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3}));
    }
}
