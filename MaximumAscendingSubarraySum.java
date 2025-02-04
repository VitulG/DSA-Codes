public class MaximumAscendingSubarraySum {

    public static int maxAscendingSum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        int currSumSoFar = nums[0];

        for(int i=1; i< nums.length; i++) {
            if(nums[i] > nums[i-1]) {
                currSumSoFar += nums[i];
            }else {
                maxSum = Math.max(maxSum, currSumSoFar);
                currSumSoFar = nums[i];
            }
        }
        return Math.max(maxSum, currSumSoFar);
    }

    public static void main(String[] args) {
        System.out.println(maxAscendingSum(new int[]{10,20,20,2,3,5,1}));
    }
}
