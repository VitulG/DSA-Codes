package Data_Structure_Algorithms_Topic_Wise_Questions.hashing;

import java.util.HashMap;
import java.util.Map;

public class ZeroSumSubarrays {

    public static int findSubarray(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int currSum = 0;
        int subarrays = 0;

        for (int num : arr) {
            currSum += num;

            if (map.containsKey(currSum)) {
                subarrays += map.get(currSum);
            }
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }
        return subarrays;
    }

    public static void main(String[] args) {
        System.out.println(findSubarray(new int[]{0, 0, 5, 5, 0, 0}));
    }
}
