package Data_Structure_Algorithms_Topic_Wise_Questions.two_pointers;

public class SortArrayByParity {

    public static int[] sortArrayByParity(int[] nums) {
        if(nums.length == 1) {
            return nums;
        }

        int le = 0;
        int ri = nums.length-1;

        while(le < ri) {
            if((nums[le]&1)==0) {
                le++;
            }

            if((nums[ri]&1) != 0) {
                ri--;
            }

            if(le < ri && (nums[le]&1)!=0 && (nums[ri]&1)==0) {
                int temp = nums[le];
                nums[le] = nums[ri];
                nums[ri] = temp;
                le++;
                ri--;
            }
        }
        return nums;

    }

    public static void main(String[] args) {
        int[] sortedArray = sortArrayByParity(new int[]{0,1});

        for(int num : sortedArray) {
            System.out.print(num+" ");
        }

    }
}
