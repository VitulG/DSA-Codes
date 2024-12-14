import java.util.TreeMap;

public class ContinuousSubarrays {
    public static long continuousSubarrays(int[] nums) {
        long subarrays = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        int st = 0;
        int en = 0;

        // properties of Tree Map
        // it's sorted and first key will be the smallest and the last will be greatest
        // used a treeMap and store the freq of the elements instead of maintaining two heaps
        // same as a standard sliding window technique

        while(en < nums.length) {
            map.put(nums[en], map.getOrDefault(nums[en], 0) + 1);

            while(map.lastKey() - map.firstKey() > 2) {
                int value = nums[st];

                map.put(value, map.get(value) -1);

                if(map.get(value) == 0) {
                    map.remove(value);
                }

                st++;
            }
            subarrays += (en - st + 1);
            en++;
        }
        return subarrays;
    }

    public static void main(String[] args) {
        System.out.println(continuousSubarrays(new int[]{5,4,2,4}));
    }
}
