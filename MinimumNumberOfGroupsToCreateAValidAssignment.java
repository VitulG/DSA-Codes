import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfGroupsToCreateAValidAssignment {

    public static int minGroupsForValidAssignment(int[] balls) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int ball : balls) {
            map.put(ball, map.getOrDefault(ball, 0) + 1);
        }


        return 0;
    }

    public static void main(String[] args) {
        minGroupsForValidAssignment(new int[]{10,10,10,3,1,1});
    }
}
