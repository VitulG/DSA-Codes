public class MinimumOperationsToMakeBinaryArrayElementsEqualToOneI {

   public static int minOperations(int[] nums) {
       int flipCount = 0;

       for(int i=2; i<nums.length; i++) {
           if(nums[i-2] == 0) {
               flipCount++;
               nums[i-2] = 1 - nums[i-2];
               nums[i-1] = 1 - nums[i-1];
               nums[i] = 1 - nums[i];
           }
       }

       int totalSum = 0;

       for(int num : nums) {
           totalSum += num;
       }
       return (totalSum == nums.length) ? flipCount : -1;
   }

    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{0,1,1,1}));
    }
}
