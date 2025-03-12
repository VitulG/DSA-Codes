public class MaximumCountOfPositiveIntegerAndNegativeInteger {

    public static int binarySearchForNegatives(int[] nums) {
        int lo = 0;
        int hi = nums.length-1;

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if(nums[mid] < 0) {
                lo = mid + 1;
            }else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    public static int binarySearchForPositives(int[] nums) {
        int lo = 0;
        int hi = nums.length-1;

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if(nums[mid] > 0) {
                hi = mid-1;
            }else {
                lo = mid+1;
            }
        }
        return nums.length - lo;
    }

    public static int maximumCount(int[] nums) {
        int negativeCount = binarySearchForNegatives(nums);
        int positiveCount = binarySearchForPositives(nums);

        return Math.max(negativeCount, positiveCount);
    }

    public static void main(String[] args) {
        System.out.println(maximumCount(new int[]{5,20,66,1314}));
    }
}
