import java.util.HashMap;
import java.util.Map;

public class MakeTwoArraysEqualByReversingSubarrays {

    public static boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int ele : target) {
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }

        for(int ele : arr) {
            if(!map.containsKey(ele)) {
                return false;
            }

            int value = map.get(ele);

            if(value == 1) {
                map.remove(ele);
            }else {
                map.put(ele, value-1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canBeEqual(new int[]{1,2,2,3}, new int[]{1,1,2,3}));
    }
}