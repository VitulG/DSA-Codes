package Data_Structure_Algorithms_Topic_Wise_Questions.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EqualRowAndColumnPairs {

    /*
        The Approach is to make every row as String and add it in a map how many time this row has come increase the
            count by 1 of that row string
            TC -> O(n^2), SC -> O(n^2)
     */

    public static int equalPairs(int[][] grid) {
        Map<String, Integer> map = new HashMap<>();

        for(int row = 0; row < grid.length; row++) {
            StringBuilder currentRow = new StringBuilder();
            for(int col = 0; col < grid[row].length; col++) {
                currentRow.append(grid[row][col]).append(",");
            }
            map.put(currentRow.toString(), map.getOrDefault(currentRow.toString(), 0) + 1);
        }

        int pairs = 0;

        for(int col = 0; col < grid[0].length; col++) {
            StringBuilder currentColumn = new StringBuilder();
            for(int row =0; row < grid.length; row++) {
                currentColumn.append(grid[row][col]).append(",");
            }
            if(map.containsKey(currentColumn.toString())) {
                pairs += map.get(currentColumn.toString());
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        System.out.println(equalPairs(new int[][]{
                {3,1,2,2},
                {1,4,4,5},
                {2,4,2,2},
                {2,4,2,2}
        }));
    }
}
