package Data_Structure_Algorithms_Topic_Wise_Questions.hashing;

import java.util.HashMap;
import java.util.Map;

public class SubarrayWithZeroSum {

    public static boolean findSum(int[] arr) {

        // Approach 1. Brute force to generate all the subarray and check if there is subarray with 0 sum
        // TC -> O(n^3) SC -> O(n)

        // Approach 2. Using Hashing and Prefix sum to track sum which index has this sum if yes, we found a subarray else false;
        // TC -> O(n) SC -> O(n)

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int currSum = 0;

        for(int i=0; i<arr.length; i++) {
            currSum += arr[i];

            if(map.containsKey(currSum)) {
                return true;
            }
            map.put(currSum, i);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(findSum(new int[]{1, 2, -1}));
    }
}
