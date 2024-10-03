import java.util.HashMap;
import java.util.Map;

public class MakeSumDivisibleByP {

    public static int minSubarray(int[] nums, int p) {

        int totalSum = 0;

        for(int ele : nums) {
            totalSum = (totalSum + ele) % p;
        }


        int target = totalSum % p;

        if(target == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int minSubarrayLength = nums.length;
        int currSum = 0;

        for(int i=0; i<nums.length; i++) {
            currSum = (currSum + nums[i]) % p;

            int prevSum = (currSum - target + p) % p;

            if(map.containsKey(prevSum)) {
                minSubarrayLength = Math.min(minSubarrayLength, i - map.get(prevSum));
            }
            map.put(currSum, i);
        }
        return minSubarrayLength == nums.length ? -1 : minSubarrayLength;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int p = 7;
        System.out.println(minSubarray(nums, p));
    }
}
