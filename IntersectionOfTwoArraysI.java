import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArraysI {

    public static int[] intersection(int[] arr1, int[] arr2) {
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();

        for(int num : arr1) {
            set1.add(num);
        }

        for(int num : arr2) {
            if(set1.contains(num)) {
                set2.add(num);
            }
        }

        int[] ans = new int[set2.size()];
        int idx = 0;

        java.util.Iterator<Integer> it = set2.iterator();

        while(it.hasNext()) {
            ans[idx++] = it.next();
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
