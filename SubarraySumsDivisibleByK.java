import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisibleByK {

    public static int subarraysDivByK(int[] nums, int k) {
        // brute force
        // int count = 0;
        // for(int i=0; i<nums.length; i++) {
        //     int sum = 0;
        //     for(int j=i; j<nums.length; j++) {
        //         sum += nums[j];
        //         if(sum % k == 0) count++;
        //     }
        // }
        // return count;

        // optimal solution is to use hashmap with prefix sum
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);

        int sum   = 0;
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];

            int rem = sum%k;

            // if(rem < 0) {
            //     rem += k;
            // }

            if(map.containsKey(rem)) {
                count += map.get(rem);
            }
            map.put(rem, map.getOrDefault(rem, 0)+1);
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(subarraysDivByK(new int[]{-1,2,9}, 2));
    }
    
}
