package Data_Structure_Algorithms_Topic_Wise_Questions.arrays_strings;

import java.util.Arrays;

public class RotateArray {

    public static void reverse(int[] nums, int st, int en) {
        while(st < en) {
            int temp = nums[st];
            nums[st] = nums[en];
            nums[en] = temp;
            st++;
            en--;
        }
    }

    public static void rotate(int[] nums, int k) {
        if(nums.length == 1) {
            return;
        }
        int len = nums.length;
        int rotate = k % len;

        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, rotate - 1);
        reverse(nums, rotate, len-1);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
