package Data_Structure_Algorithms_Topic_Wise_Questions.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsIII {

    /*
        Approach: - 1. Sort the meeting based on their start times to keep which meeting will start first.
                    2. Keep two queues for maintaining which room is available and which room is occupied.
                    3. First check if the room is free or not before the next meeting if yes move that room to available rooms
                    4. Else if we have one room which is available, then use that room and increase the count by 1.
                    5. Else We have to check which occupied room has the least exit time to give that room to another meeting.
                    6. In the end, We just need to check which room is used the most and return that room.

                    TC -> O(n log n)
                    SC -> O(n) // used Meeting array, 2 priority queues, and Room array
     */

    static class Meeting {
        int startTime;
        int endTime;

        public Meeting(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    static class Room {
        int roomNumber;
        long lastUsedAt;
        long numberOfTimesRoomUsed;

        public Room(int roomNumber, long lastUsedAt, long numberOfTimesRoomUsed) {
            this.roomNumber = roomNumber;
            this.lastUsedAt = lastUsedAt;
            this.numberOfTimesRoomUsed = numberOfTimesRoomUsed;
        }
    }

    public static int mostBooked(int n, int[][] meetings) {
        int totalMeetings = meetings.length;

        Meeting[] meetings1 = new Meeting[totalMeetings];
        int idx = 0;

        for(int[] meeting : meetings) {
            meetings1[idx++] = new Meeting(meeting[0], meeting[1]);
        }

        Arrays.sort(meetings1, (m1, m2) -> Integer.compare(m1.startTime, m2.startTime));

        Room[] totalRooms = new Room[n];
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();

        for(int i=0; i<n; i++) {
            totalRooms[i] = new Room(i, 0L, 0L);
            availableRooms.offer(i);
        }

        PriorityQueue<Room> occupiedRooms = new PriorityQueue<>((r1, r2) -> {
            if (r1.lastUsedAt != r2.lastUsedAt) {
                return Long.compare(r1.lastUsedAt, r2.lastUsedAt);
            }
            return Integer.compare(r1.roomNumber, r2.roomNumber);
        });

        for(Meeting meeting : meetings1) {
            int start = meeting.startTime;
            int end = meeting.endTime;
            int duration = end - start;

            while(!occupiedRooms.isEmpty() && occupiedRooms.peek().lastUsedAt <= start) {
               int freedRoomNumber = occupiedRooms.poll().roomNumber;
               availableRooms.offer(freedRoomNumber);
            }

            if(!availableRooms.isEmpty()) {
                int roomNumber = availableRooms.poll();
                Room room = totalRooms[roomNumber];
                room.numberOfTimesRoomUsed++;
                room.lastUsedAt = end;
                occupiedRooms.offer(room);
            }else {
                Room earlyFinishedRoom = occupiedRooms.poll();
                long exitTime = earlyFinishedRoom.lastUsedAt;
                earlyFinishedRoom.numberOfTimesRoomUsed++;
                earlyFinishedRoom.lastUsedAt = exitTime + duration;
                occupiedRooms.offer(earlyFinishedRoom);
            }
        }

        int maxRoomUsed = -1;
        long maxMeetings = Long.MIN_VALUE;

        for(int i=0; i<n; i++) {
            if(totalRooms[i].numberOfTimesRoomUsed > maxMeetings) {
                maxMeetings = totalRooms[i].numberOfTimesRoomUsed;
                maxRoomUsed = i;
            }
        }
        return maxRoomUsed;
    }

    public static void main(String[] args) {
        System.out.println(mostBooked(4, new int[][]{
                {0,8},
                {1,4},
                {3,4},
                {2,3}
        }));
    }
}
