package Data_Structure_Algorithms_Topic_Wise_Questions.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {

    /*
        Approach: - 1. Sort the meeting on the basis of their start time.
                    2. Use a priority queue to maintain which meeting will end in min time. (Min heap will help here)
                    3. whenever any meeting that has more starting time, we can discard that previous meeting
                    4. else we have to make another room to make that meeting happen.

                    TC -> O(n log n)
                    SC -> O(n)
     */

    static class Meeting {
        int startTime;
        int endTime;

        public Meeting(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static int minMeetingRooms(int[] start, int[] end) {
        // code here
        int totalMeetings = start.length;

        Meeting[] meetings = new Meeting[totalMeetings];

        for(int i=0; i<totalMeetings; i++) {
            meetings[i] = new Meeting(start[i], end[i]);
        }

        Arrays.sort(meetings, (a, b) -> Integer.compare(a.startTime, b.startTime));

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int conferenceRooms = 1;
        queue.offer(meetings[0].endTime);


        for(int i=1; i<meetings.length; i++) {
            if(!queue.isEmpty() && meetings[i].startTime < queue.peek()) {
                conferenceRooms++;
                queue.offer(meetings[i].endTime);
            }else {
                queue.poll();
                queue.offer(meetings[i].endTime);
            }
        }
        return conferenceRooms;
    }

    public static void main(String[] args) {
        System.out.println(minMeetingRooms(new int[]{2,9,6}, new int[]{4,12,10}));
    }
}
