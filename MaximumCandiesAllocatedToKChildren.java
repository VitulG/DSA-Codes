import java.util.Arrays;

public class MaximumCandiesAllocatedToKChildren {

    public static boolean isPossibleToDistributeCandy(int[] candies, int child, long k) {
       long count = 0L;

       for(int candyPile : candies) {
           count += (candyPile/child);
       }
       return count >= k;
    }

    public static int maximumCandies(int[] candies, long k) {
        long totalCandies = 0;

        for(int candy : candies) {
            totalCandies += candy;
        }

        if(totalCandies < k) {
            return 0;
        }

        int lo = 1;
        int hi = (int)(totalCandies / k);

        int maxCandies = 0;

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if(isPossibleToDistributeCandy(candies, mid, k)) {
                maxCandies = mid;
                lo = mid+1;
            }else {
                hi = mid-1;
            }
        }
        return maxCandies;
    }

    public static void main(String[] args) {
        System.out.println(maximumCandies(new int[]{5,8,6}, 3));
    }
}
