import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {

    public static int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int num : nums1) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        List<Integer> list = new ArrayList<Integer>();

        for(int num : nums2) {
            if(map.containsKey(num)) {
                list.add(num);

                int value = map.get(num)-1;

                if(value == 0) {
                    map.remove(num);
                }else {
                    map.put(num, value);
                }
            }
        }

        int[] ans = new int[list.size()];

        for(int i = 0; i<list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] ans = intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4});
        
        for(int i : ans) {
            System.out.print(i+" ");
        }
    }
    
}
