public class FindTheMaximumSumOfNodeValues {
    public static long maximumValueSum(int[] nums, int k, int[][] edges) {
        long ans = 0l;
        long currMinDiff = Long.MAX_VALUE;
        int countNodes = 0;

        for(int i=0; i<nums.length; i++) {
            if((nums[i]^k) > nums[i]) {
                ans += (nums[i]^k);
                countNodes++;
            }else{
                ans += nums[i];
            }
            currMinDiff = Math.min(currMinDiff, Math.abs(nums[i] - (nums[i]^k)));

        }
        return (countNodes%2 == 0) ? ans : ans - currMinDiff;
    }

    public static void main(String[] args) {
        System.out.println(maximumValueSum(new int[]{1,2,2}, 3, new int[][]{{0,1}, {0,2}}));  
    }
}
