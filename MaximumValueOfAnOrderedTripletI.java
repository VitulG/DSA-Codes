public class MaximumValueOfAnOrderedTripletI {

    public static long maximumTripletValue(int[] nums) {
        long maxValue = Integer.MIN_VALUE;

        for(int i=0; i<nums.length-2; i++) {
            for(int j=i+1; j<nums.length-1; j++) {
                for(int k=j+1; k<nums.length; k++) {
                    maxValue = Math.max(maxValue, (long) (nums[i] - nums[j]) *nums[k]);
                }
            }
        }
        return Math.max(maxValue, 0);
    }

    public static void main(String[] args) {
        System.out.println(maximumTripletValue(new int[]{1,2,3}));
    }
}
