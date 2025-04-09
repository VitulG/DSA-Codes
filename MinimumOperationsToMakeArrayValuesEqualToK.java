import java.util.HashMap;
import java.util.Map;

public class MinimumOperationsToMakeArrayValuesEqualToK {

    public static boolean isStrictlyGreaterNums(int[] nums, int h) {
        for(int num : nums) {
            if(num < h) {
                return false;
            }
        }
        return true;
    }

    public static int minOperations(int[] nums, int k) {
        if(!isStrictlyGreaterNums(nums, k)) {
            return -1;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        int kCount = 0;

        for(int key : map.keySet()) {
            if(key == k) {
                kCount++;
            }
        }
        return map.size() - kCount;
    }

    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{9,7,5,3}, 1));
    }
}
