import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(target-nums[i])) {
                return new int[]{map.get(target-nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1,-1};

    }

    public static void main(String[] args) {

        int[] re = twoSum(new int[]{3,2,4}, 6);

        System.out.println(re[0]+" "+re[1]);

    }

}