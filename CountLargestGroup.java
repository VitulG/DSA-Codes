import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountLargestGroup {

    public static long getSum(int num) {
        long sum = 0;

        while(num != 0) {
            int rem = num%10;
            sum += rem;
            num /= 10;
        }
        return sum;
    }

    public static int countLargestGroup(int n) {
        if(n < 10) {
            return n;
        }

        Map<Long, List<Integer>> map = new HashMap<>();

        for(int i = 1; i<=n; i++) {
            long sum = getSum(i);

            if(map.containsKey(sum)) {
                List<Integer> currList = map.get(sum);
                currList.add(i);
            }else {
                List<Integer> newList = new ArrayList<>();
                newList.add(i);
                map.put(sum, newList);
            }
        }

        int maxSize = Integer.MIN_VALUE;

        for(List<Integer> list : map.values()) {
            maxSize = Math.max(maxSize, list.size());
        }

        int largestGroups = 0;

        for(List<Integer> list : map.values()) {
            if(list.size() == maxSize) {
                largestGroups++;
            }
        }
        return largestGroups;
    }

    public static void main(String[] args) {
        System.out.println(countLargestGroup(13));
    }
}
