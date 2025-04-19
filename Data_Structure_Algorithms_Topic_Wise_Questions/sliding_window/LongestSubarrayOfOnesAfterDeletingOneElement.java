package Data_Structure_Algorithms_Topic_Wise_Questions.sliding_window;

public class LongestSubarrayOfOnesAfterDeletingOneElement {

    public static int longestSubarray(int[] nums) {

        // Approach 1. Brute force is generate all the subarrays and check which subarray containing most ones
        // TC -> O(n^3) and SC -> O(1)

        // Approach 2. Optimal is using sliding window i.e. expand around a 0 check their left and right how many ones
        //              are there and sum them. TC -> O(n) SC -> O(1)

        int totalOnes = 0;

        for(int num : nums) {
            if(num == 1) {
                totalOnes++;
            }
        }

        if(totalOnes == nums.length) {
            return nums.length-1;
        }

        int subarray = 0;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                int left = i-1;
                int right = i+1;

                int countFromLeft = 0;
                int countFromRight = 0;

                while(left >= 0 && nums[left] == 1) {
                    countFromLeft++;
                    left--;
                }

                while(right < nums.length && nums[right] == 1) {
                    countFromRight++;
                    right++;
                }
                subarray = Math.max(subarray, countFromLeft + countFromRight);
            }
        }
        return subarray;
    }

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));
    }
}
