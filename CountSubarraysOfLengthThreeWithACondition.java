public class CountSubarraysOfLengthThreeWithACondition {

    public static int countSubarrays(int[] nums) {
        if(nums.length < 3) {
            return 0;
        }

        int subarrays = 0;

        int first = nums[0];
        int second = nums[1];
        int third = nums[2];

        if((first + third)*2 == second) {
            subarrays++;
        }

        for(int i=3; i< nums.length; i++) {
            first = nums[i-2];
            second = nums[i-1];
            third = nums[i];

            if((first + third)*2 == second) {
                subarrays++;
            }
        }
        return subarrays;
    }

    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{1,2,1,4,1}));
    }
}
