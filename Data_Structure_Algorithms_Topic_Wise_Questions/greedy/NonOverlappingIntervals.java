package Data_Structure_Algorithms_Topic_Wise_Questions.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    /*
        Approach:
            To maximize the number of non-overlapping intervals, use a greedy strategy.
            Always pick the interval with the earliest end time to leave room for future intervals.
            So, we sort all intervals based on their end times.

                Time Complexity: O(n log n) due to sorting
                Space Complexity: O(1)
     */

    public static int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                return Integer.compare(a1[1], a2[1]);
            }
        });

        int totalIntervals = intervals.length;
        int nonOverlappingIntervals = 1;
        int currentEndTime = intervals[0][1];

        for(int i=1; i<intervals.length; i++) {
            if(intervals[i][0] >= currentEndTime) {
                nonOverlappingIntervals++;
                currentEndTime = intervals[i][1];
            }
        }
        return totalIntervals - nonOverlappingIntervals;
    }

    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(new int[][]{
                {1,100},
                {11,22},
                {1,11},
                {2,12}
        }));
    }
}
