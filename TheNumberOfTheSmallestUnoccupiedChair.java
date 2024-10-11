import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Friend {
    int friendId;
    int arrivalTime;
    int leavingTime;

    public Friend(int friendId, int arrivalTime, int leavingTime) {
        this.friendId = friendId;
        this.arrivalTime = arrivalTime;
        this.leavingTime = leavingTime;
    }
}

public class TheNumberOfTheSmallestUnoccupiedChair {

    static class SortFriends implements Comparator<Friend> {

        @Override
        public int compare(Friend friend1, Friend friend2) {
            return Integer.compare(friend1.arrivalTime,friend2.arrivalTime);
        }
    }

    public static int smallestChair(int[][] times, int targetFriend) {
        int len = times.length;

        Friend[] friends = new Friend[len];

        for(int i=0; i<times.length; i++) {
            friends[i] = new Friend(i, times[i][0], times[i][1]);
        }
        Arrays.sort(friends, new SortFriends());

        PriorityQueue<Integer> availableChair = new PriorityQueue<>();

        for(int i=0; i<len; i++) {
            availableChair.offer(i);
        }

        // we will keep track of friend's leaving time to make this seat available
        PriorityQueue<int[]> occupiedChair = new PriorityQueue<>((a,b) -> Integer.compare( a[0], b[0]));

        for(Friend friend : friends) {
            while(!occupiedChair.isEmpty() && occupiedChair.peek()[0] <= friend.arrivalTime) {
                availableChair.offer(occupiedChair.poll()[1]); // removing that seat from occupied chair and add as an empty chair
            }

            int smallestNumberOfChair = availableChair.poll();

            if(friend.friendId == targetFriend) {
                return smallestNumberOfChair;
            }

            occupiedChair.offer(new int[]{friend.leavingTime, smallestNumberOfChair});
        }
        return -1;

    }

    public static void main(String[] args) {
        int[][] times = {{1,4},{2,3},{4,6}};
        int targetFriend = 1;
        System.out.println(smallestChair(times, targetFriend)); // Output: 1
    }
}
