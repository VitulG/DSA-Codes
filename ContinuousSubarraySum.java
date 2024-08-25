import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {

    public static boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length < 2) {
            return false;
        }
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);

        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];

            int rem = sum % k;

            if(map.containsKey(rem)) {
                if(i - map.get(rem) > 1) {
                    return true;
                }
            }else {
                map.put(rem, i);
            }
        }
        return false;

    }


    public static void main(String[] args) {
        System.out.println(checkSubarraySum(new int[]{23,2,6,4,7}, 6));
    }
}
