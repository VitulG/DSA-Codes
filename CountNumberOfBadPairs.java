import java.util.HashMap;
import java.util.Map;

public class CountNumberOfBadPairs {

    public static long countBadPairs(int[] nums) {

        for(int i=0; i<nums.length; i++) {
            nums[i] = nums[i] - i;
        }

        long badPairs = 0L;

        Map<Integer, Integer> map = new HashMap<>();

        // we have to check position. ith will tell how many element we have on the left side and
        // the current number count will be stored in the map

        for(int i=0; i<nums.length; i++) {
            int prevNumCount = map.getOrDefault(nums[i], 0);

            badPairs += i - prevNumCount;

            map.put(nums[i], prevNumCount + 1);
        }
        return badPairs;

    }

    public static void main(String[] args) {
        System.out.println(countBadPairs(new int[]{1,2,3,4,5}));
    }
}
