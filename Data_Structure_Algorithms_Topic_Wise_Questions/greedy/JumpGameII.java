package Data_Structure_Algorithms_Topic_Wise_Questions.greedy;

import java.util.Arrays;

public class JumpGameII {

    /*
        Approach 1. Using Brute force, check all the steps we will take at a particular position and check what will be the
                        minimum steps recursively, use DP for less calculation.
                    TC -> O(n * number)
                    SC -> O(n)

        Approach 2. Greedy Approach, we can take a current window if our index exceeds that window we have to take a step
                        and check accordingly.
                    TC -> O(n)
                    SC -> O(1)
     */

    public static int getMinimumJump(int[] nums, int idx, int[] dp) {
        if(idx >= nums.length -1) {
            return 0;
        }

        if(nums[idx] == 0) {
            return Integer.MAX_VALUE;
        }

        if(dp[idx] != -1) {
            return dp[idx];
        }

        int minJump = Integer.MAX_VALUE;

        for(int jump = 1; jump <= nums[idx]; jump++) {
            int next = getMinimumJump(nums, idx + jump, dp);

            if(next != Integer.MAX_VALUE) {
                minJump = Math.min(minJump, next+1);
            }
        }
        return dp[idx] = minJump;
    }

    public static int jump(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, -1);

        return getMinimumJump(nums, 0, dp);
    }

    public static int jumpUsingGreedy(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        int minSteps = 0;
        int maxJumps = Integer.MIN_VALUE;
        int currentJumps = 0;

        for(int i=0; i<nums.length; i++) {
            maxJumps = Math.max(maxJumps, nums[i] + i);

            if(currentJumps >= nums.length -1) {
                break;
            }

            if(i == currentJumps) {
                minSteps++;
                currentJumps = maxJumps;
            }

        }
        return minSteps;
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,1,1,4}));
        System.out.println(jumpUsingGreedy(new int[]{2,3,1,1,4}));
    }
}
