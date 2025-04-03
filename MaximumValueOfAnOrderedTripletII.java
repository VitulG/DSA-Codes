public class MaximumValueOfAnOrderedTripletII {

    public static long maximumTripletValue(int[] nums) {
        if(nums.length < 3) {
            return 0L;
        }

        int[] preMax = new int[nums.length];
        preMax[0] = nums[0];

        for(int i=1; i<nums.length; i++) {
            preMax[i] = Math.max(preMax[i-1], nums[i]);
        }

        int[] sufMax = new int[nums.length];
        sufMax[sufMax.length-1] = nums[nums.length-1];

        for(int i = sufMax.length-2; i>= 0; i--) {
            sufMax[i] = Math.max(sufMax[i+1], nums[i]);
        }

        long maxTripletValue = 0L;

        for(int i=1; i<nums.length-1; i++) {
            int leftIMax = preMax[i-1];
            int rightKMax = sufMax[i+1];

            maxTripletValue = Math.max(maxTripletValue, (long) (leftIMax - nums[i]) * rightKMax);

        }
        return maxTripletValue;
    }

    /*
   - Mujhe **maximum value** nikalni hai `(nums[i] - nums[j]) * nums[k]` expression ki.
   - Iske liye `i` aur `k` ke **maximum values** dhoondhna zaroori hai har index pe.

   🔹 **Prefix Array:**
      - Har index `i` tak **left side ka maximum element** store karega.
      - `preMax[i] = max(preMax[i-1], nums[i])`

   🔹 **Suffix Array:**
      - Har index `k` tak **right side ka maximum element** store karega.
      - `sufMax[i] = max(sufMax[i+1], nums[i])`

   🔹 **Final Step:**
      - Iterate `j` from `1` to `n-2` (kyunki `j > i` hona chahiye).
      - `maxValue = max(maxValue, (preMax[j-1] - nums[j]) * sufMax[j+1])`
    */


    public static void main(String[] args) {
        System.out.println(maximumTripletValue(new int[]{12,6,1,2,7}));
    }
}
