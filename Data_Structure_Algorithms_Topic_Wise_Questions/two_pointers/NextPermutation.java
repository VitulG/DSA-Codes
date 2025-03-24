package Data_Structure_Algorithms_Topic_Wise_Questions.two_pointers;

import java.util.Arrays;

public class NextPermutation {

    public static void swapArray(int[] nums, int st, int en) {
        while(st < en) {
            int temp = nums[st];
            nums[st] = nums[en];
            nums[en] = temp;
            st++;
            en--;
        }
    }

    public static void nextPermutation(int[] nums) {
        // step 1. find the dip from the right
        int dip = -1;

        for(int i = nums.length-2; i>=0; i--) {
            if(nums[i] < nums[i+1]) {
                dip = i;
                break;
            }
        }

        if(dip == -1) {
            swapArray(nums, 0, nums.length-1);
        }else {
            // step 2. find the next greater element in the array from arr[dip] and swap them
            int j = nums.length-1;
            while(j > dip) {
                if(nums[j] > nums[dip]) {
                    int temp = nums[j];
                    nums[j] = nums[dip];
                    nums[dip] = temp;
                    break;
                }
                j--;
            }
            swapArray(nums, dip+1, nums.length-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,1,3};
        nextPermutation(nums);

        System.out.println(Arrays.toString(nums));
    }
}
