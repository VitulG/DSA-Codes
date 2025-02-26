public class MaximumAbsoluteSumOfAnySubarray {

    public static int maxAbsoluteSum(int[] nums) {
        int currentMaxSum = 0, maxSum = Integer.MIN_VALUE;
        int currentMinSum = 0, minSum = Integer.MAX_VALUE;

        for (int num : nums) {
            currentMaxSum = Math.max(num, currentMaxSum + num);
            maxSum = Math.max(maxSum, currentMaxSum);

            currentMinSum = Math.min(num, currentMinSum + num);
            minSum = Math.min(minSum, currentMinSum);
        }
        return Math.max(maxSum, Math.abs(minSum));
    }

    public static void main(String[] args) {
        System.out.println(maxAbsoluteSum(new int[]{2,-5,1,-4,3,-2}));
    }
}
