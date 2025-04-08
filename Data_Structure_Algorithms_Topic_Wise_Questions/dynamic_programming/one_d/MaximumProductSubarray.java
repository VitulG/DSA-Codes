package Data_Structure_Algorithms_Topic_Wise_Questions.dynamic_programming.one_d;

public class MaximumProductSubarray {

    public static int maxProduct(int[] nums) {
        // Approach 1. Brute force generate all the sub arrays and get check for the sub array which has the highest multiple
        // TC => O(n^3) SC => O(1) TLE

        // Optimal Approach check the highest multiple from left and right side and take the max if pointer == 0 then reset to 0
        // TC => O(n) SC => O(1)

        int multiplyFromLeft = 1;
        int multiplyFromRight = 1;

        int maxSubarrayProduct = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++) {
            multiplyFromLeft = (multiplyFromLeft == 0) ? 1 : multiplyFromLeft;
            multiplyFromRight = (multiplyFromRight == 0) ? 1 : multiplyFromRight;

            multiplyFromLeft *= nums[i];
            multiplyFromRight *= nums[nums.length-1-i];

            maxSubarrayProduct = Math.max(maxSubarrayProduct, Math.max(multiplyFromLeft, multiplyFromRight));
        }
        return maxSubarrayProduct;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{1,3,-9,7,-1,0,3,10,4,-1}));
    }
}
