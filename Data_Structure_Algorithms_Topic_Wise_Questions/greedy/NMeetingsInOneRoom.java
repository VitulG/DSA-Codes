package Data_Structure_Algorithms_Topic_Wise_Questions.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class NMeetingsInOneRoom {

    /*
        Approach: - here we can take meetings greedily so that we can attend as much as possible meetings
                    1. Sort the meetings according to their end time.
                    2. And now we have to check if the current meeting end time < next meeting starts time
                    3. then we can pick that meeting and move next and so on.
            TC -> O(n log n)
            SC -> O(n) // meeting array
     */


    static class Meeting {
        int startTime;
        int endTime;

        public Meeting(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static int maxMeetings(int[] start, int[] end) {
        int len = start.length;
        Meeting[] meetings = new Meeting[len];

        for(int i=0; i<len; i++) {
            meetings[i] = new Meeting(start[i], end[i]);
        }

        Arrays.sort(meetings, (m1, m2) -> Integer.compare(m1.endTime, m2.endTime));

        int meetingAttended = 1;
        int currentEndTime = meetings[0].endTime;

        for(int i=1; i<meetings.length; i++) {
            if(meetings[i].startTime > currentEndTime) {
                meetingAttended++;
                currentEndTime = meetings[i].endTime;
            }
        }
        return meetingAttended;

    }

    public static void main(String[] args) {
        System.out.println(maxMeetings(new int[]{1, 3, 0, 5, 8, 5}, new int[]{2, 4, 6, 7, 9, 9}));
    }
}
