import java.util.Arrays;

public class NumberOfSubsequencesThatSatisfyTheGivenSumCondition {

    public static int numSubseq(int[] nums, int target) {
        if(nums.length == 0) {
            return 0;
        }

        // because subsequence generates on 2^n that's why
        int[] power = new int[nums.length];
        power[0] = 1;
        int MOD = 1000000007;

        for(int i=1; i<nums.length; i++) {
            power[i] = (power[i-1] * 2)%MOD;
        }

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length-1;

        int subsequences = 0;

        while(left <= right) {
            if(nums[left] + nums[right] <= target) {
                subsequences = (subsequences + power[right - left]) % MOD;
                left++;
            }else {
                right--;
            }
        }
        return subsequences;
    }

    public static void main(String[] args) {
        System.out.println(numSubseq(new int[]{2,3,3,4,6,7}, 12));
    }
}
