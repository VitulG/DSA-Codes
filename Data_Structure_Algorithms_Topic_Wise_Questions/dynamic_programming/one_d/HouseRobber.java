package Data_Structure_Algorithms_Topic_Wise_Questions.dynamic_programming.one_d;

import java.util.Arrays;

public class HouseRobber {

    public static int getMaximumMoney(int[] nums, int idx, int[] dp) {
        if(idx >= nums.length) {
            return 0;
        }

        if(dp[idx] != -1) {
            return dp[idx];
        }

        // not take
        int whenSkipHouse = getMaximumMoney(nums, idx+1, dp);

        // if you take
        int whenTakeHouse = nums[idx] + getMaximumMoney(nums, idx+2, dp);

        return dp[idx] = Math.max(whenSkipHouse, whenTakeHouse);
    }

    public static int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return getMaximumMoney(nums, 0, dp);
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1}));
    }
}
