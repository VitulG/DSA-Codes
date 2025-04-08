package Data_Structure_Algorithms_Topic_Wise_Questions.dynamic_programming.one_d;

public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        // Approach 1. using Brute force approach is generate all the sub arrays and check for the largest sum
        // TC -> O(n^3) SC -> O(1) => TLE

        // Approach 2. Using Prefix sum pre-calculate the sum which index what is the same till here
        // TC -> O(n^2) SC -> O(n) => might be accepted

        // Approach 3. Using Kadane's algo
        // TC -> O(n) SC -> O(1) => accepted

        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for(int num : nums) {
            currSum += num;
            maxSum = Math.max(currSum, maxSum);
            currSum = Math.max(currSum, 0);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
