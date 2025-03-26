package Data_Structure_Algorithms_Topic_Wise_Questions.two_pointers;

public class SortColors {

    public static void swap(int[] nums, int st, int en) {
        int temp = nums[st];
        nums[st] = nums[en];
        nums[en] = temp;
    }

    public static void sortColors(int[] nums) {
        // Approach 1. use either any sorting algorithm or custom comparator
        // Approach 2. using frequency array to store the frequencies 0f 0, 1, and 2
        // Approach 3. using Dutch national Flag algorithm

        int le = 0;
        int mid = 0;
        int ri = nums.length-1;

        while(mid <= ri) {
            if(nums[mid] == 0) {
                swap(nums, le, mid);
                le++;
                mid++;
            }else if(nums[mid] == 1) {
                mid++;
            }else {
                swap(nums, mid, ri);
                ri--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        sortColors(nums);
        for(int num : nums) {
            System.out.print(num+" ");
        }
    }
}
