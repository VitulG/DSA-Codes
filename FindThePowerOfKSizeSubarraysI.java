public class FindThePowerOfKSizeSubarraysI {

    public static int[] resultArray(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        int idx = 0;

        for(int i=0; i<= nums.length-k; i++) {
            boolean isConsecutive = true;

            for(int j = i; j < i + k - 1; j++) {
                if(nums[j] + 1 != nums[j+1]) {
                    isConsecutive = false;
                    break;
                }
            }

            if(isConsecutive) {
                ans[idx++] = nums[i+k-1];
            }else{
                ans[idx++] = -1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] result = resultArray(new int[]{3,2,3,2,3,2}, 2);

        for(int num : result) {
            System.out.print(num+" ");
        }
    }
}
