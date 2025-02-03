public class LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {

    public static int longestMonotonicSubarray(int[] nums) {
        int incSubarray = 0;
        int decSubarray = 0;

        int currentIncSubarray = 1;
        int currentDecSubarray = 1;

        for(int i=1; i< nums.length; i++) {
            if(nums[i] < nums[i-1]) {
                currentDecSubarray++;
            }else {
                decSubarray = Math.max(decSubarray, currentDecSubarray);
                currentDecSubarray = 1;
            }

            if(nums[i] > nums[i-1]) {
                currentIncSubarray++;
            } else {
                incSubarray = Math.max(incSubarray, currentIncSubarray);
                currentIncSubarray = 1;
            }
        }

        return Math.max(Math.max(currentIncSubarray, currentDecSubarray), Math.max(incSubarray, decSubarray));
    }

    public static void main(String[] args) {
        System.out.println(longestMonotonicSubarray(new int[]{3,2,1}));
    }
}
