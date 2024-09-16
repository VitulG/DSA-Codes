import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumTimeDifference {

    public static int findMinDifference(List<String> timePoints) {
        List<Integer> minutes = new ArrayList<>();

        for(String timePoint : timePoints) {
            int hour = Integer.parseInt(timePoint.substring(0, 2));
            int minute = Integer.parseInt(timePoint.substring(3));
            minutes.add(hour * 60 + minute);
        }

        Collections.sort(minutes);

        int minDifference = Integer.MAX_VALUE;

        for(int i = 1; i < minutes.size(); i++) {
            minDifference = Math.min(minDifference, minutes.get(i) - minutes.get(i - 1));
        }
        return Math.min(minDifference, (1440 - minutes.getLast())+minutes.getFirst());
    }

    public static void main(String[] args) {
        List<String> timePoints = List.of("23:59", "00:02");
        System.out.println(findMinDifference(timePoints));
    }
}
