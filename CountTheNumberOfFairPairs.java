import java.util.Arrays;

public class CountTheNumberOfFairPairs {

    public static int getLowerElements(int[] nums, int lo, int hi, int target) {
        while(lo < hi) {
            int mid = lo + (hi-lo) / 2;
            if(nums[mid] < target) {
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        return lo;
    }

    public static int getUpperElements(int[] nums, int lo, int hi, int target) {
        while(lo < hi) {
            int mid = lo + (hi - lo) /2;

            if(nums[mid] <= target) {
                lo = mid + 1;
            }else {
                hi = mid;
            }
        }
        return lo;
    }

    public static long countFairPairs(int[] nums, int lower, int upper) {
        // we can use binary search here to get lower and upper bound elements;
        Arrays.sort(nums);

        long pairs = 0L;

        for(int i=0; i<nums.length; i++) {
            int lowerElements = getLowerElements(nums, i+1, nums.length, lower - nums[i]) - 1 - i;
            int upperElements = getUpperElements(nums, i+1, nums.length, upper - nums[i]) - 1 - i;

            pairs += (upperElements - lowerElements);
        }
        return pairs;
    }

    public static void main(String[] args) {
        System.out.println(countFairPairs(new int[]{1,7,9,2,5}, 11,11));
    }
}
