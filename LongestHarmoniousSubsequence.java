import java.util.Arrays;

public class LongestHarmoniousSubsequence {

    public static int findLHS(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int longestLHS = 0;
        int left = 0;
        int right = 0;

        while(right < nums.length) {
            if(nums[right] - nums[left] == 1) {
                longestLHS = Math.max(longestLHS, right - left+1);
            }

            while(nums[right] - nums[left] > 1) {
                left++;
            }
            right++;
        }
        return longestLHS;
    }

    public static void main(String[] args) {
        System.out.println(findLHS(new int[]{1,1,1,1}));
    }
}
