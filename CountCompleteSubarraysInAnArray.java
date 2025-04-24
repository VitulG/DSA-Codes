import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountCompleteSubarraysInAnArray {

    public static int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums) {
            set.add(num);
        }

        int distinct = set.size();
        int completeSubarray = 0;

        int left = 0;
        int right = 0;

        Map<Integer, Integer> map = new HashMap<>();

        while(right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) +1);

            while(map.size() == distinct) {
                completeSubarray += (nums.length - right);
                map.put(nums[left], map.get(nums[left])-1);

                if(map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            right++;
        }

        return completeSubarray;
    }

    public static void main(String[] args) {
        System.out.println(countCompleteSubarrays(new int[]{5,5,5,5}));
    }
}
