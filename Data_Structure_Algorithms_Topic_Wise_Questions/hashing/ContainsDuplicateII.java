package Data_Structure_Algorithms_Topic_Wise_Questions.hashing;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {

    /*
        Approach 1: Brute Force
            - Use two nested loops to check every pair (i, j)
            - If nums[i] == nums[j] and |i - j| <= k, return true
            - Time Complexity: O(n^2)
            - Space Complexity: O(1)

        Approach 2: Optimized using HashMap
            - Traverse the array while storing each number and its index in a HashMap
            - For each number, if it already exists in the map, check if the difference of indices ≤ k
            - If yes, return true; otherwise, update the index of the number
            - Time Complexity: O(n)
            - Space Complexity: O(n)
     */

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length == 0) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i< nums.length; i++) {
            if(map.containsKey(nums[i]) && Math.abs(i - map.get(nums[i])) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
    }
}
