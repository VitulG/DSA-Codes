import java.util.HashMap;
import java.util.Map;

public class FindTheMaximumLengthOfValidSubsequenceI {

    public static int getMaximumSubsequence(int[] nums, int idx, int prev, int lastMod, Map<String, Integer> dp) {
        if(idx >= nums.length) {
            return 0;
        }

        String key = idx+","+prev+","+lastMod;

        if(dp.containsKey(key)) {
            return dp.get(key);
        }

        int skip = getMaximumSubsequence(nums, idx+1, prev, lastMod, dp);
        int take = 0;

        if(prev == -1) {
            take = 1 + getMaximumSubsequence(nums, idx+1, nums[idx], -1, dp);
        }else if(lastMod == -1) {
            take = 1 + getMaximumSubsequence(nums, idx+1, nums[idx], (prev + nums[idx]) %2, dp);
        }else {
            if((nums[idx] + prev) % 2 == lastMod) {
                take = 1 + getMaximumSubsequence(nums, idx+1, nums[idx], lastMod,dp);
            }
        }

        int result = Math.max(skip, take);
        dp.put(key, result);
        return result;
    }

    public static int maximumLengthUsingDP(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        Map<String, Integer> dp = new HashMap<>();

        return getMaximumSubsequence(nums, 0, -1, -1, dp);
    }

    public static int maximumLength(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        int maxSubsequence = Integer.MIN_VALUE;

        int oddSeq = 0;
        int evenSeq = 0;

        for(int num : nums) {
            if((num&1) != 0) {
                oddSeq++;
            }else {
                evenSeq++;
            }
        }

        maxSubsequence = Math.max(oddSeq, evenSeq);

        int parity = ((nums[0]&1) == 0) ? 0 : 1;
        int alterSeq = 0;

        for (int num : nums) {
            if ((num & 1) == parity) {
                alterSeq++;
                parity = 1 - parity;
            }
        }

        return Math.max(maxSubsequence, alterSeq);
    }

    public static void main(String[] args) {
        System.out.println(maximumLength(new int[]{1,2,1,1,2,1,2}));
    }
}
