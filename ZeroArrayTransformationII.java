import java.util.Arrays;

public class ZeroArrayTransformationII {

    public static boolean isPossibleToMakeArrayZero(int[] nums, int[][] queries, int k) {

        int[] differenceArray = new int[nums.length+1];
        for(int i=0; i<nums.length; i++) {
            differenceArray[i] = nums[i];
        }

        for(int i=0; i<k; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int val = queries[i][2];

            differenceArray[l] -= val;
            differenceArray[r+1] += val;
        }

        int sum = 0;

        for(int i =0; i<nums.length; i++) {
            sum += differenceArray[i];

            if(sum > nums[i]) {
                return false;
            }
        }
        return true;
    }

    public static int minZeroArray(int[] nums, int[][] queries) {
        int lo = 1;
        int hi = queries.length;

        int k = -1;

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if(isPossibleToMakeArrayZero(nums, queries, mid)) {
                k = mid;
                hi = mid-1;
            }else {
                lo = mid+1;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        System.out.println(minZeroArray(new int[]{2,0,2}, new int[][]{
                {0,2,1},
                {0,2,1},
                {1,1,3}
        }));
    }
}
