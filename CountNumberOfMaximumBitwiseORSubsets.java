public class CountNumberOfMaximumBitwiseORSubsets {

    public static int helper(int[] nums, int idx, int currOr, int maxOr) {
        if(idx >= nums.length) {
            if(currOr == maxOr) {
                return 1;
            }
            return 0;
        }

        int notTakeOrNum = helper(nums, idx+1, currOr, maxOr);
        int takeOrNum = helper(nums, idx+1, currOr|nums[idx], maxOr);


        return notTakeOrNum + takeOrNum;

    }

    public static int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for(int num : nums) {
            maxOr = maxOr|num;
        }

        return helper(nums, 0, 0, maxOr);
    }

    public static void main(String[] args) {
        System.out.println(countMaxOrSubsets(new int[]{3,2,1,5}));
    }
}
