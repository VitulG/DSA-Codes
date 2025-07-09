import java.util.ArrayList;
import java.util.List;

public class RescheduleMeetingsForMaximumFreeTimeI {
    static class Meeting {
        int startTime;
        int endTime;

        public Meeting(int st, int et) {
            this.startTime = st;
            this.endTime = et;
        }
    }

    public static int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int len = startTime.length;

        Meeting[] meetings = new Meeting[len];

        for(int i=0; i<len; i++) {
            meetings[i] = new Meeting(startTime[i], endTime[i]);
        }

        List<Integer> freeTimes = new ArrayList<>();
        freeTimes.add(meetings[0].startTime);

        int currentEndTime = meetings[0].endTime;

        for(int i=1; i<meetings.length; i++) {
            freeTimes.add(meetings[i].startTime - currentEndTime);
            currentEndTime = meetings[i].endTime;
        }

        freeTimes.add(eventTime - meetings[meetings.length-1].endTime);

        if(freeTimes.size() < k+1) {
            return freeTimes.stream()
                    .mapToInt(i -> i)
                    .sum();
        }

        int maxFreeTime = Integer.MIN_VALUE;
        int currentFreeTime = 0;

        for(int i=0; i<k+1; i++) {
            currentFreeTime += freeTimes.get(i);
        }
        maxFreeTime = Math.max(maxFreeTime, currentFreeTime);

        for(int i=k+1; i<freeTimes.size(); i++) {
            int out = freeTimes.get(i - (k+1));
            int in = freeTimes.get(i);

            currentFreeTime = (currentFreeTime - out + in);
            maxFreeTime = Math.max(maxFreeTime, currentFreeTime);
        }
        return maxFreeTime;
    }

    public static void main(String[] args) {
        System.out.println(maxFreeTime(10, 1, new int[]{0,2,9}, new int[]{1,4,10}));
    }
}
