import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumSumOf3NonOverlappingSubarrays {
    public static int[][] dp;

    private static int getSubarraySum(List<Integer> subarraySum, int idx, int k, int count) {
        if(count == 3) {
            return 0;
        }

        if(idx >= subarraySum.size()) {
            return Integer.MIN_VALUE;
        }

        if(dp[idx][count] != -1) {
            return dp[idx][count];
        }

        int takeSum = subarraySum.get(idx) + getSubarraySum(subarraySum, idx+k, k, count+1);
        int notTakeSum = getSubarraySum(subarraySum, idx+1, k, count);

        return dp[idx][count] = Math.max(takeSum, notTakeSum);

    }

    private static void calculateMaxSubarrayIndices(List<Integer> subarraySum, int idx, int k, int count, List<Integer> indices) {
        if(count == 3) {
            return;
        }

        if(idx >= subarraySum.size()) {
            return;
        }

        // step 3. apply dp on sum
        int takeSubarraySum = subarraySum.get(idx) + getSubarraySum(subarraySum, idx+k, k, count+1);
        int notTakeSubarraySum = getSubarraySum(subarraySum, idx+1, k, count);


        if(takeSubarraySum >= notTakeSubarraySum) {
            indices.add(idx);
            calculateMaxSubarrayIndices(subarraySum, idx+k, k, count+1, indices);
        }else {
            calculateMaxSubarrayIndices(subarraySum, idx+1, k, count, indices);
        }

    }

    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        // step1. calculate the sum of each window of size k
        List<Integer> subarraySum = new ArrayList<>();

        int currSum = 0;
        for(int i=0; i<k; i++) {
            currSum += nums[i];
        }
        subarraySum.add(currSum);

        for(int i=k; i<nums.length; i++) {
            currSum = (currSum + nums[i] - nums[i-k]);
            subarraySum.add(currSum);
        }

        List<Integer> indices = new ArrayList<>();

        // initialize dp
        dp = new int[20001][4];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // step 2. apply recursion to check for indices
        calculateMaxSubarrayIndices(subarraySum, 0, k, 0, indices);

        int[] ans = new int[indices.size()];

        for(int i=0; i<indices.size(); i++) {
            ans[i] = indices.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] result = maxSumOfThreeSubarrays(new int[]{1,2,1,2,6,7,5,1}, 2);

        for (int j : result) {
            System.out.print(j + " ");
        }
    }
}
