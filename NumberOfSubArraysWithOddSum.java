public class NumberOfSubArraysWithOddSum {

    public static int numOfSubarrays(int[] arr) {
        long oddSumSubarrays = 0L;
        int MOD = 1000000007;

        int oddCount = 0;
        int evenCount = 1;

        long currSum = 0L;

        for(int num : arr) {
            currSum += num;

            // odd case
            if((currSum & 1) != 0) {
                oddSumSubarrays += evenCount;
                oddCount++;
            }else {
                oddSumSubarrays += oddCount;
                evenCount++;
            }

            oddSumSubarrays %= MOD;
        }
        return (int) oddSumSubarrays;
    }

    public static void main(String[] args) {
        System.out.println(numOfSubarrays(new int[]{1,2,3,4,5,6,7}));
    }
}
