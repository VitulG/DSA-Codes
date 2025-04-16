import java.util.HashMap;
import java.util.Map;

public class CountTheNumberOfGoodSubarrays {

    public static long countGood(int[] nums, int k) {
        int len = nums.length;

        int le = 0;
        int ri = 0;

        Map<Integer, Integer> map = new HashMap<>();

        long totalPairs = 0L;
        long ans = 0L;

        while(ri < len) {
            int num = nums[ri];
            int freq = map.getOrDefault(num, 0);
            totalPairs += freq;
            map.put(num, freq+1);

            while(totalPairs >= k) {
                ans += (len - ri);
                int leftNum = nums[le];
                map.put(leftNum, map.get(leftNum) - 1);
                totalPairs -= map.get(leftNum);
                le++;
            }
            ri++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countGood(new int[]{1,1,1,1,1}, 10));
    }
}
