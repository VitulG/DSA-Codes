import java.util.Arrays;

public class MinimumIncrementToMakeArrayUnique {

    public static int minIncreamentForUnique(int[] nums) {
        Arrays.sort(nums);

        int moves = 0;

        for(int i=1; i<nums.length; i++) {
            if(nums[i] <= nums[i-1]) {
                int increment = nums[i-1] - nums[i] + 1;
                nums[i] += increment;
                moves += increment;
            }
        }
        return moves;
    }

    public static void main(String[] args) {
        System.out.println(minIncreamentForUnique(new int[]{3,4,6,5,8}));
    }
}
