import java.util.HashMap;
import java.util.Map;

class FindSumPairs {
    private int[] first;
    private int[] second;
    private final Map<Integer, Integer> map;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.first = nums1;
        this.second = nums2;
        this.map = new HashMap<>();

        for(int num : nums2) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

    }

    public void add(int index, int val) {
        int oldVal = second[index];
        map.put(oldVal, map.get(oldVal) - 1);
        second[index] += val;
        map.put(second[index], map.getOrDefault(second[index], 0) + 1);
    }

    public int count(int tot) {
        int pairs = 0;

        for(int num : this.first) {
            int rem = tot - num;

            if(this.map.containsKey(rem)) {
                pairs += this.map.get(rem);
            }
        }
        return pairs;
    }
}

public class FindingPairsWithACertainSum {
    public static void main(String[] args) {
        FindSumPairs findSumPairs = new FindSumPairs(new int[]{1, 1, 2, 2, 2, 3}, new int[]{1, 4, 5, 2, 5, 4});
        System.out.println(findSumPairs.count(7));  // return 8; pairs (2,2), (3,2), (4,2), (2,4), (3,4), (4,4) make 2 + 5 and pairs (5,1), (5,5) make 3 + 4
        findSumPairs.add(3, 2); // now nums2 = [1,4,5,4,5,4]
        System.out.println(findSumPairs.count(8));  // return 2; pairs (5,2), (5,4) make 3 + 5
        System.out.println(findSumPairs.count(4));  // return 1; pair (5,0) makes 3 + 1
        findSumPairs.add(0, 1); // now nums2 = [2,4,5,4,5,4]
        findSumPairs.add(1, 1); // now nums2 = [2,5,5,4,5,4]
        System.out.println(findSumPairs.count(7));  // return 11;
    }
}
