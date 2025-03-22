package Data_Structure_Algorithms_Topic_Wise_Questions.two_pointers;

import java.util.Arrays;

public class NumberOfSubsequencesThatSatisfyTheGivenSumCondition {

    public static int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);

        int MOD = 1000000007;
        int lo = 0;
        int hi = nums.length-1;

        int[] pow = new int[nums.length];
        pow[0] = 1;

        for(int i=1; i<nums.length; i++) {
            pow[i] = (pow[i-1]*2)%MOD;
        }

        int subsequences = 0;

        while(lo <= hi) {
            if(nums[lo] + nums[hi] <= target) {
                subsequences = (subsequences + pow[hi-lo])%MOD;
                lo++;
            }else {
                hi--;
            }
        }
        return subsequences;
    }

    /*
        Note => Humne Power kyu generate ki hai kyuki hi-lo we have subsequences jo ki 2^n hoti hai
        ye to le ya na isliye power ko accurately calculate karne ke liye maine power array banaya
        just add the power in which these are the set which is <= target then it will include.
     */

    public static void main(String[] args) {
        System.out.println(numSubseq(new int[]{2,3,3,4,6,7}, 12));
    }
}
