import java.util.Arrays;

public class MaximumBeautyOfAnArrayAfterApplyingOperation {
    public static boolean isArraySame(int[] nums) {
        for(int i=1; i<nums.length; i++) {
            if(nums[i] != nums[i-1]) {
                return false;
            }
        }
        return true;
    }

    public static int maximumBeauty(int[] nums, int k) {
        // edge 1. agar length of array 1 hai to use case main ans hamesha 1 hi rahega TC -> O(1)
        if(nums.length == 1) {
            return 1;
        }

        // edge 2. agar saare array elements same hai to ans hamesha ans.length hi hoga TC -> O(n)
        if(isArraySame(nums)) {
            return nums.length;
        }

        // otherwise sort kar lo array ko phir hum par bahut saari algorithm hai like sliding window TC -> O(n log n)
        Arrays.sort(nums);

        int left = 0;
        int right = 0;
        int len = nums.length;

        int maxBeauty = Integer.MIN_VALUE;

        while(right < len) {
            // humne 2 * k kyu kiya kyuki range main hamesha double elements hi honge if the element 2 hai aur k 1 so range will be 1 2 3 isiliye baaki to sliding window hi hai
            while(nums[right] - nums[left] > 2 * k) {
                left++;
            }

            maxBeauty = Math.max(maxBeauty, right - left + 1);
            right++;
        }
        return maxBeauty;
    }

    // TC => O(n + n log n + 2*n) => O(n log n)
    // SC => O(1)

    public static void main(String[] args) {
        System.out.println(maximumBeauty(new int[]{4,6,1,2}, 2));
    }
}
