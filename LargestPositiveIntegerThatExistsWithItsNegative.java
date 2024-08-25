import java.util.HashSet;
import java.util.Set;

public class LargestPositiveIntegerThatExistsWithItsNegative {

    public static int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();

        for(int ele : nums) {
            set.add(ele);
        }

        int ans = Integer.MIN_VALUE;
        for(int ele : nums) {
            int opp = -ele;
            if(set.contains(opp)) {
                ans = Math.max(ans, ele);
            }
        }
        return (ans==Integer.MIN_VALUE) ? -1 : ans;

    }

    public static void main(String[] args) {
        System.out.println(findMaxK(new int[]{-1,2,-3,3}));
    }
    
}
