package Data_Structure_Algorithms_Topic_Wise_Questions.sliding_window;

public class MaxConsecutiveOnesIII {

    /*
        Approach 1. Brute force approach is saying that we have to generate all the subarrays and then
            check How many subarrays contain 1's with at most k 0's in it return that max subarray size.
                TC -> O(n^3) SC -> O(1)

        Approach 2. Using Sliding window technique, we may read the length of that subarray until zero count crosses
            the limit, and then we have to shrink our window then.
                TC -> O(n), SC -> O(1)
     */

    public static int longestOnes(int[] nums, int k) {
        if(nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;

        int longestConsecutiveOnes = Integer.MIN_VALUE;
        int zeroes = 0;

        while(right < nums.length) {
            if(nums[right] == 0) {
                zeroes++;
            }

            while(zeroes > k) {
                if(nums[left] == 0) {
                    zeroes--;
                }
                left++;
            }
            longestConsecutiveOnes = Math.max(longestConsecutiveOnes, right-left+1);
            right++;
        }
        return longestConsecutiveOnes;
    }

    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }
}
