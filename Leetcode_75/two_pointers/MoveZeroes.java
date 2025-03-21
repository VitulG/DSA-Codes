package Leetcode_75.two_pointers;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int idx = 0;

        for(int num : nums) {
            if(num != 0) {
                nums[idx++] = num;
            }
        }

        while(idx < nums.length) {
            nums[idx++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,3,12};
        moveZeroes(arr);

        for(int num : arr) {
            System.out.print(num+" ");
        }
    }
}
