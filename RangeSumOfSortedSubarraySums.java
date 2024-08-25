import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RangeSumOfSortedSubarraySums {

    public static int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> subarraySum = new ArrayList<Integer>();

        for(int i=0; i<n; i++) {
            int sum = 0;
            for(int j=i; j<n; j++) {
                sum+=nums[j];
                subarraySum.add(sum);
            }
        }

        Collections.sort(subarraySum);

        long rangeSum = 0;
        int mod = 1000000007;

        for(int i = left-1; i<right; i++) {
            rangeSum = (rangeSum + subarraySum.get(i))%mod;
        }

        rangeSum %= mod;

        return (int) rangeSum;
    }

    public static void main(String[] args) {
        System.out.println(rangeSum(new int[]{1,2,3,4}, 4, 1, 10));
    }
}