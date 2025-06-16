public class MaximumDifferenceBetweenIncreasingElements {

    public static int maximumDifference(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int maxDifference = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[j] > nums[i]) {
                    maxDifference = Math.max(maxDifference, nums[j] - nums[i]);
                }
            }
        }
        return maxDifference == Integer.MIN_VALUE ? -1 : maxDifference;
    }

    public static void main(String[] args) {
        System.out.println(maximumDifference(new int[]{7,1,5,4}));
    }
}
