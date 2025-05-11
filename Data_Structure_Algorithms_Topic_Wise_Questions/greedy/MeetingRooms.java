package Data_Structure_Algorithms_Topic_Wise_Questions.greedy;

import java.util.Arrays;

public class MeetingRooms {
    /*
        Approach: - Sort the array on the basis of their start time and check if a person can attend all meetings or not
                        TC -> O(n log n)
                        SC -> O(1)
    */

    public static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        int currentEndTime = intervals[0][1];

        for(int i=1; i<intervals.length; i++) {
            if(intervals[i][0] <= currentEndTime) {
                return false;
            }
            currentEndTime = intervals[i][1];
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canAttendMeetings(new int[][]{
                {0,30},
                {5,10},
                {15,20}
        }));
    }
}
