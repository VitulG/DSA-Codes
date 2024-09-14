public class LongestSubarrayWithMaximumBitwiseAND {
    public static int longestSubarray(int[] nums) {
        int ans = 0;
        int streak = 0;
        int maxValue = 0;

        for(int num : nums) {
            if(num > maxValue) {
                maxValue = num;
                streak = 0;
                ans = 0;
            }

            if(num == maxValue) {
                streak++;
            }else {
                streak=0;
            }

            ans = Math.max(ans, streak);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{1,2,3,3,2,2}));
    }
}
