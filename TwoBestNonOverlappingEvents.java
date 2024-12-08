import java.util.Arrays;

public class TwoBestNonOverlappingEvents {
    public static int maxTwoEvents(int[][] events) {
        // step 1. sort the array on the basis of their end time
        Arrays.sort(events, (a,b) -> Integer.compare(a[1], b[1]));

        int len = events.length;
        int[] maxSumSoFar = new int[len];
        maxSumSoFar[0] = events[0][2];

        // compute the max till that state by checking max with the last event sum
        for(int i=1; i<len; i++) {
            maxSumSoFar[i] = Math.max(events[i][2], maxSumSoFar[i-1]);
        }

        // apply binary search for the get the next non overlapping interval
        return getMaxSum(events, len, maxSumSoFar);
    }

    private static int getMaxSum(int[][] events, int len, int[] maxSumSoFar) {
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i< len; i++) {
            int currSum = events[i][2];

            int lo = 0;
            int hi = i -1;

            int best = -1;

            while(lo <= hi) {
                int mid = lo + (hi - lo) / 2;

                if(events[mid][1] < events[i][0]) {
                    best = mid;
                    lo = mid + 1;
                }else {
                    hi = mid - 1;
                }
            }

            if(best != -1) {
                currSum += maxSumSoFar[best];
            }
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxTwoEvents(new int[][]{
                {1,3,2},
                {4,5,2},
                {2,4,3}
        }));
    }
}
