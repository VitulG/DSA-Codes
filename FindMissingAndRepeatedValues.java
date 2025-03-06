import java.util.HashMap;
import java.util.Map;

public class FindMissingAndRepeatedValues {

    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] row : grid) {
            for (int num : row) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        int missing = -1;
        int twice = -1;

        int len = grid.length;

        for(int i=1; i<=len*len; i++) {
            if(!map.containsKey(i)) {
                missing = i;
            }

            if(map.containsKey(i) && map.get(i) == 2) {
                twice = i;
            }
        }
        return new int[]{twice, missing};

    }

    public static void main(String[] args) {
        int[] result = findMissingAndRepeatedValues(new int[][]{
                {9,1,7},
                {8,9,2},
                {3,4,6},
        });

        System.out.println(result[0]+" "+result[1]);
    }
}
