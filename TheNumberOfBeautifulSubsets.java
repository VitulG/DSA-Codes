import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TheNumberOfBeautifulSubsets {

    public static int generateBeautifulSubsets(int[] nums, int idx, int k, Set<Integer> set) {
        if(idx >= nums.length) {
            return set.isEmpty() ? 0 : 1;
        }

        int count = generateBeautifulSubsets(nums, idx+1, k, set);

        if(set.contains(Math.abs(nums[idx]-k))) {
            return count;
        }

        set.add(nums[idx]);
        count += generateBeautifulSubsets(nums, idx+1, k, set);
        set.remove(nums[idx]);

        return count;

    }

    public static int beautifulSubsets(int[] nums, int k) {
        if(nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        return generateBeautifulSubsets(nums, 0, k, new HashSet<Integer>());

    }
    
    public static void main(String[] args) {
        System.out.println(beautifulSubsets(new int[]{2,4,6}, 2));
    }
}
