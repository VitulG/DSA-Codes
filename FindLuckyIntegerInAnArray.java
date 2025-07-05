import java.util.HashMap;
import java.util.Map;

public class FindLuckyIntegerInAnArray {

    public static int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : arr) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        int ans = -1;

        for(Map.Entry<Integer, Integer> en : map.entrySet()) {
            int num = en.getKey();
            int freq = en.getValue();

            if(num == freq) {
                ans = num;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findLucky(new int[]{2,2,2,3,3}));
    }
}
