package Data_Structure_Algorithms_Topic_Wise_Questions.sliding_window;

public class MinimumSizeSubarraySum {

    public static int minSubArrayLen(int target, int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        int minSubarray = Integer.MAX_VALUE;
        int le = 0;
        int ri = 0;

        int currSum = 0;

        while(ri < nums.length) {
            currSum += nums[ri];

            while(currSum >= target) {
                minSubarray = Math.min(minSubarray, ri-le+1);
                currSum -= nums[le];
                le++;
            }
            ri++;
        }
        return minSubarray == Integer.MAX_VALUE ? 0 : minSubarray;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
}
