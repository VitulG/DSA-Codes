import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindTheNumberOfDistinctColorsAmongTheBalls {

    public static int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> colorBalls = new HashMap<>(); // for coloring x -> y
        Map<Integer, Integer> colorBallsCount = new HashMap<>(); // how many balls one color has

        int[] ans = new int[queries.length];
        int idx = -1;

        for(int[] query : queries) {
            int x = query[0];
            int y = query[1];

            if(colorBalls.containsKey(x)) {
                int prevColor = colorBalls.get(x);
                colorBalls.put(x, y);

                colorBallsCount.put(prevColor, colorBallsCount.get(prevColor) - 1);

                if(colorBallsCount.get(prevColor) == 0) {
                    colorBallsCount.remove(prevColor);
                }
            }

            colorBalls.put(x, y);
            colorBallsCount.put(y, colorBallsCount.getOrDefault(y, 0) + 1);

            ans[++idx] = colorBallsCount.size();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] result = queryResults(1, new int[][]{
                {0,1},
                {1,4},
                {1,1},
                {1,4},
                {1,1}
        });

        for(int ele : result) {
            System.out.print(ele+" ");
        }
    }
}
