package Data_Structure_Algorithms_Topic_Wise_Questions.hashing;

import java.util.HashMap;
import java.util.Map;

public class SubarrayWithZeroSum {

    public static boolean findSum(int[] arr) {
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
