import java.util.Arrays;

public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {
    
    public static int minDifference(int[] nums) {
        
        int size = nums.length;

        if(size <= 4) {
            return 0;
        }

        Arrays.sort(nums);
        
        int result = Integer.MAX_VALUE;

        // Case 1: Remove the three largest elements
        result = Math.min(result, nums[size - 4] - nums[0]);

        // Case 2: Remove the two largest and one smallest element
        result = Math.min(result, nums[size - 3] - nums[1]);

        // Case 3: Remove the one largest and two smallest elements
        result = Math.min(result, nums[size - 2] - nums[2]);

        // Case 4: Remove the three smallest elements
        result = Math.min(result, nums[size - 1] - nums[3]);

        return result;
    }

    public static void main(String[] args) {
        System.out.println(minDifference(new int[]{6,6,0,1,1,4,6}));
    }
    
}
