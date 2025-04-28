package Data_Structure_Algorithms_Topic_Wise_Questions.arrays_strings;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        int idx = 1;
        int i = 1;

        while(i < nums.length) {
            if(nums[i] != nums[i-1]) {
                nums[idx++] = nums[i];
            }
            i++;
        }
        return idx;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));

        System.out.println(Arrays.toString(nums));

    }
}
