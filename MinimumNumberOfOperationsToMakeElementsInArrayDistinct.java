import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfOperationsToMakeElementsInArrayDistinct {

    public static boolean isNumsDistinct(Map<Integer, Integer> map) {
        for(int value : map.values()) {
            if(value != 1) {
                return false;
            }
        }
        return true;
    }

    public static int minimumOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int minOps = 0;
        int idx = 0;

        while(!isNumsDistinct(map)) {
            if(nums.length - idx < 3) {
                return minOps+1;
            }
            int till = idx+3;
            while(idx < nums.length && idx < till) {
                map.put(nums[idx], map.get(nums[idx])-1);
                if(map.get(nums[idx]) == 0) {
                    map.remove(nums[idx]);
                }
                idx++;
            }
            minOps++;
        }
        return minOps;
    }

    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[]{1,2,3,4,2,3,3,5,7}));
    }
}
