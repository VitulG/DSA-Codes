package Data_Structure_Algorithms_Topic_Wise_Questions.two_pointers;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SortArrayByParityII {

    public static int[] sortArrayByParityII(int[] nums) {
        if(nums.length == 0) {
            return nums;
        }

        int evenIdx = 0;
        int oddIdx = 1;

        while(evenIdx < nums.length && oddIdx < nums.length) {
            while(evenIdx < nums.length && (nums[evenIdx]&1) == 0) {
                evenIdx += 2;
            }

            while(oddIdx < nums.length && (nums[oddIdx]&1) != 0) {
                oddIdx += 2;
            }

            if(evenIdx < nums.length && oddIdx < nums.length) {
                int temp = nums[evenIdx];
                nums[evenIdx] = nums[oddIdx];
                nums[oddIdx] = temp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParityII(new int[]{4,2,5,7})));
    }
}
