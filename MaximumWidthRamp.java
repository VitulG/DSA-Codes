import java.util.Stack;

public class MaximumWidthRamp {

    public static int maxWidthRamp(int[] nums) {
        int[] rightMax = new int[nums.length];
        rightMax[nums.length-1] = nums[nums.length-1];

        for(int i=nums.length-2; i>=0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], nums[i]);
        }

        int ramp = 0;
        int i=0;
        int j=0;

        while(j < rightMax.length) {
            while(i < j && nums[i] > rightMax[j]) {
                i++;
            }
            ramp = Math.max(ramp, j - i);
            j++;
        }
        return ramp;
    }

    public static void main(String[] args) {
        int[] nums = {9,8,1,0,1,9,4,0,4,1};
        System.out.println(maxWidthRamp(nums)); // Output: 4
    }
}
