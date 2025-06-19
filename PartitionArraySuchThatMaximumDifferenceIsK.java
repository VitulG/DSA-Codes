import java.util.Arrays;

public class PartitionArraySuchThatMaximumDifferenceIsK {

    public static int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);

        int subsequences = 1;
        int min = nums[0];

        for(int i=1; i<nums.length; i++) {
            if(nums[i] - min > k) {
                subsequences++;
                min = nums[i];
            }
        }
        return subsequences;
    }

    public static void main(String[] args) {
        System.out.println(partitionArray(new int[]{3,6,1,2,5}, 2));
    }
}
