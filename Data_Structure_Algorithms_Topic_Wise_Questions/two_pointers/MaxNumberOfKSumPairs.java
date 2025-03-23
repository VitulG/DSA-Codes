package Data_Structure_Algorithms_Topic_Wise_Questions.two_pointers;

import java.util.Arrays;

public class MaxNumberOfKSumPairs {

    public static int maxOperations(int[] nums, int k) {
        if(nums.length <= 1) {
            return 0;
        }

        Arrays.sort(nums);

        int le = 0;
        int ri = nums.length-1;

        int maxOps = 0;

        while(le < ri) {
            if(nums[le] + nums[ri] == k) {
                maxOps++;
                le++;
                ri--;
            }else if(nums[le] + nums[ri] < k) {
                le++;
            }else {
                ri--;
            }
        }
        return maxOps;
    }

    public static void main(String[] args) {
        System.out.println(maxOperations(new int[]{3,1,3,4,3}, 6));
    }
}
