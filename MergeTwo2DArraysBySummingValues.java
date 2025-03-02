import java.util.Map;
import java.util.TreeMap;

public class MergeTwo2DArraysBySummingValues {

    public static int[][] mergeArray(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map = new TreeMap<>();

        for(int[] row : nums1) {
            int id = row[0];
            int value = row[1];

            map.put(id, map.getOrDefault(id, 0) + value);
        }

        for(int[] row : nums2) {
            int id = row[0];
            int value = row[1];

            if(map.containsKey(id)) {
                map.put(id, map.get(id) + value);
            }else {
                map.put(id, map.getOrDefault(id, 0) + value);
            }
        }

        int[][] ans = new int[map.size()][2];
        int idx = 0;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans[idx][0] = entry.getKey();
            ans[idx][1] = entry.getValue();
            idx++;
        }

        return ans;

    }

    public static void main(String[] args) {
        mergeArray(new int[][]{
                {1,2},
                {2,3},
                {4,5}
        }, new int[][]{
                {1,4},
                {3,2},
                {4,1}
        });
    }
}
