package Data_Structure_Algorithms_Topic_Wise_Questions.hashing;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {
        // Approach 1. Using Brute Force generates subarrays and checks if there is any subarray that has the sum equal k
        // TC -> O(n^3), SC -> O(1)

        // Approach 2. Using Hashing if the current subarray contains curr - k sum, previously we can check it efficiently using Map
        // TC -> O(n), SC -> O(n)

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int subarrays = 0;
        int currSum = 0;

        for(int num : nums) {
            currSum += num;
            int requiredSum = currSum - k;

            if(map.containsKey(requiredSum)) {
                subarrays += map.get(requiredSum);
            }
            map.put(currSum, map.getOrDefault(currSum, 0)+1);
        }
        return subarrays;

    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{3,-3,1,1,1},3));
    }
}
