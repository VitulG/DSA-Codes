import java.util.HashMap;
import java.util.Map;

public class RabbitsInForest {

    public static int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : answers) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int rabbits = 0;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int color = entry.getKey() + 1;
            int colorRabbits = entry.getValue();

            int groupSize = (int) Math.ceil((double) colorRabbits / color);

            rabbits += (groupSize * color);
        }
        return rabbits;
    }

    // Time Complexity -> O(n), Space Complexity -> O(n)

    public static void main(String[] args) {
        System.out.println(numRabbits(new int[]{1,1,2}));
        System.out.println(numRabbits(new int[]{10,10,10}));
    }
}
