import java.util.HashMap;
import java.util.Map;

public class MaxSumOfAPairWithEqualSumOfDigits {

    public static int getNumDigitSum(int num) {
        int ans = 0;

        while(num != 0) {
            int rem = num % 10;
            ans += rem;
            num /= 10;
        }
        return ans;
    }

    public static int maximumSum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            int numDigitSum = getNumDigitSum(num);

            if(map.containsKey(numDigitSum)) {
                maxSum = Math.max(maxSum, map.get(numDigitSum) + num);
                map.put(numDigitSum, Math.max(map.get(numDigitSum), num));
            }else {
                map.put(numDigitSum, num);
            }
        }
        return (maxSum == Integer.MIN_VALUE) ? -1 : maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maximumSum(new int[]{10,12,19,14}));
    }
}
