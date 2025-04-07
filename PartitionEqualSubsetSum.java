import java.util.Arrays;

public class PartitionEqualSubsetSum {

    public static boolean isPossibleToPartitionArray(int[] nums, int idx, int target, int[][] dp) {
        if(idx >= nums.length) {
            return false;
        }

        if(target < 0) {
            return false;
        }

        if(target == 0) {
            return true;
        }

        if(dp[idx][target] != -1) {
            return dp[idx][target] == 1;
        }

        boolean ifSkipElement = isPossibleToPartitionArray(nums, idx+1, target, dp);
        boolean ifTakeElement = isPossibleToPartitionArray(nums, idx+1, target-nums[idx], dp);

        boolean result = ifSkipElement || ifTakeElement;

        dp[idx][target] = result ? 1 : 0;

        return result;
    }

    public static boolean canPartition(int[] nums) {
        int target = 0;

        for(int num : nums) {
            target += num;
        }

        if(target%2 != 0) {
            return false;
        }

        int[][] dp = new int[nums.length+1][target+1];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return isPossibleToPartitionArray(nums, 0, target/2, dp);
    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1,2,5}));
    }
}
