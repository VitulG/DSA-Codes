import java.util.Arrays;
import java.util.Comparator;

public class CountDaysWithoutMeetings {

    public static int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] m1, int[] m2) {
                if(m1[0] == m2[0]) {
                    return m1[1] - m2[1];
                }
                return m1[0] - m2[0];
            }
        });
        

        int freeDays = 0;
        freeDays += (meetings[0][0] - 1);
        int endMeetingDay  = meetings[0][1];

        for(int i=1; i<meetings.length; i++) {
            if(meetings[i][0] <= endMeetingDay) {
                endMeetingDay = Math.max(endMeetingDay, meetings[i][1]);
            }else {
                freeDays += (meetings[i][0] - endMeetingDay - 1);
                endMeetingDay = meetings[i][1];
            }
        }
        freeDays += (days - endMeetingDay);

        return freeDays;
    }

    public static void main(String[] args) {
        System.out.println(countDays(10, new int[][]{
                {5,7},
                {1,3},
                {9,10}
        }));
    }
}
