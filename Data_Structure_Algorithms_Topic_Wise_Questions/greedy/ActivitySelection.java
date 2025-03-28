package Data_Structure_Algorithms_Topic_Wise_Questions.greedy;

import java.util.Arrays;

public class ActivitySelection {
    static class Pair {
        int startTime;
        int endTime;

        public Pair(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static int activitySelection(int[] start, int[] finish) {

        // step 1. make pairing with start and end
        Pair[] time = new Pair[start.length];

        for(int i=0; i<start.length; i++) {
            time[i] = new Pair(start[i], finish[i]);
        }

        // sort the array in ascending order
        Arrays.sort(time, (a, b) -> {
            if(a.endTime == b.endTime) {
                return a.startTime - b.startTime;
            }
            return a.endTime - b.endTime;
        });

        int startTime = time[0].startTime;
        int endTime = time[0].endTime;
        int activities = 1;

        for(int i=1; i<time.length; i++) {
            if(endTime < time[i].startTime) {
                activities++;
                endTime = Math.max(endTime, time[i].endTime);
                startTime = Math.min(startTime, time[i].startTime);
            }
        }
        return activities;
    }

    public static void main(String[] args) {
        System.out.println(activitySelection(new int[]{1, 3, 0, 5, 8, 5}, new int[]{2, 4, 6, 7, 9, 9}));
    }
}
