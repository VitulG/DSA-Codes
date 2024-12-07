public class MinimumLimitOfBallsInABag {

    public static boolean isPossibleToMinimizePenalty(int[] arr, int maxOp, int num) {
        int currOp = 0;
        for(int number : arr) {
            currOp += (number-1) / num;

            if(maxOp < currOp) {
                return false;
            }
        }
        return true;
    }

    public static int minimumSize(int[] nums, int maxOperations) {
        int lo = 1;
        int hi = nums[0];

        for(int num : nums) {
            hi = Math.max(hi, num);
        }

        int ans = 0;

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if(isPossibleToMinimizePenalty(nums, maxOperations, mid)) {
                ans = mid;
                hi = mid-1;
            }else {
                lo = mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minimumSize(new int[]{2,4,8,2}, 4));
    }
}
