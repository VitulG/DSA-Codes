public class NumberOfWaysToSplitArray {

    public static int waysToSplitArray(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        long totalSum = 0L;

        for(int num : nums) {
            totalSum += num;
        }

        long leftSum = 0L;
        int splitWays = 0;

        for(int i=0; i<nums.length-1; i++) {
            leftSum += nums[i];
            long rightSum = totalSum - leftSum;

            if(leftSum >= rightSum) {
                splitWays++;
            }
        }
        return splitWays;
    }

    public static void main(String[] args) {
        System.out.println(waysToSplitArray(new int[]{10,4,-8,7}));
    }
}
