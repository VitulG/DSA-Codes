package Data_Structure_Algorithms_Topic_Wise_Questions.dynamic_programming.one_d;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {

    public static int getLongestIncreasingSubsequenceLength(int[] nums, int idx, int prevIdx, int[][] dp) {
        if(idx >= nums.length) {
            return 0;
        }

        if(dp[idx][prevIdx+1] != -1) {
            return dp[idx][prevIdx+1];
        }

        int notTake = getLongestIncreasingSubsequenceLength(nums, idx+1, prevIdx, dp);
        int take = 0;

        if(prevIdx == -1 || nums[prevIdx] <= nums[idx]) {
            take = 1 + getLongestIncreasingSubsequenceLength(nums, idx+1, idx, dp);
        }
        return dp[idx][prevIdx+1] = Math.max(notTake, take);
    }

    public static int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length+1][nums.length+1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return getLongestIncreasingSubsequenceLength(nums, 0, -1, dp);
    }

    public static int getIndex(List<Integer> list, int target) {
        int idx = list.size()-1;

        int lo =0;
        int hi = list.size()-1;

        while(lo <= hi) {
            int mid = lo + (hi - lo) /2;

            if(list.get(mid) >= target) {
                idx = mid;
                hi = mid-1;
            }else {
                lo = mid+1;
            }
        }
        return idx;
    }

    public static int lengthOfLISUsingBinarySearch(int[] nums) {
        List<Integer> sortedList = new ArrayList<>();
        sortedList.add(nums[0]);

        for(int i=1; i<nums.length; i++) {
            if(nums[i] > sortedList.get(sortedList.size()-1)) {
                sortedList.add(nums[i]);
            }else {
                int idx = getIndex(sortedList, nums[i]);
                sortedList.set(idx, nums[i]);
            }
        }
        return sortedList.size();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLISUsingBinarySearch(new int[]{10,9,2,5,3,7,101,18}));
    }
}
