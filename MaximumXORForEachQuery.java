import java.util.Arrays;

public class MaximumXORForEachQuery {

    public static int[] getMaximumXor(int[] nums, int maximumBit) {
        // step 1. calculate the overall xor
        int XOR = 0;

        for(int num : nums) {
            XOR ^= num;
        }

        // bit mask hum 2^n-1 karenge to get the maximum result
        int mask = (1 << maximumBit) -1;

        int[] ans = new int[nums.length];

        for(int i=0; i<nums.length; i++) {
            int k = XOR ^ mask;
            ans[i] = k;

            XOR ^= nums[nums.length-1-i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] result = getMaximumXor(new int[]{2,3,4,7}, 3);

        Arrays.stream(result)
                .forEach(System.out::println);
    }
}
