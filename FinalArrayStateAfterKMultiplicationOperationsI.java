public class FinalArrayStateAfterKMultiplicationOperationsI {

    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        while(k-- > 0){
            int minValue = Integer.MAX_VALUE;
            int minIdx = -1;

            for(int i=0; i<nums.length; i++){
                if(nums[i] < minValue) {
                    minValue = nums[i];
                    minIdx = i;
                }
            }

            nums[minIdx] = minValue * multiplier;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] result = getFinalState(new int[]{2,1,3,5,6}, 5, 2);

        for(int num : result) {
            System.out.print(num+" ");
        }
    }
}
