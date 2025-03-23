package Data_Structure_Algorithms_Topic_Wise_Questions.two_pointers;

import java.util.Arrays;

public class MinimizeMaximumPairSumInArray {

    public static int minPairSum(int[] nums) {
        Arrays.sort(nums);

        int le = 0;
        int ri = nums.length-1;

        int pairSum = Integer.MIN_VALUE;

        while(le < ri) {
            pairSum = Math.max(pairSum, nums[le] + nums[ri]);
            le++;
            ri--;
        }
        return pairSum;
    }

    public static void main(String[] args) {
        System.out.println(minPairSum(new int[]{3,5,4,2,4,6}));
    }
}
