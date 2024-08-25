import java.util.HashMap;
import java.util.Map;

public class CountNumberOfNiceSubarrays {

    public static int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);

        int oddCount = 0;
        int result = 0;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] %2 != 0) {
                oddCount++;
            }

            if(map.containsKey(oddCount-k)) {
                result += map.get(oddCount-k);
            }
            map.put(oddCount, map.getOrDefault(oddCount, 0)+1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSubarrays(new int[]{2,2,2,1,2,2,1,2,2,2}, 2));
    }   
}
