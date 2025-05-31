package Data_Structure_Algorithms_Topic_Wise_Questions.hashing;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    /*
        Approach 1. Brute force approach checks every element using two nested loops, but we have to make sure i != j
                        and element will be the same if yes return true else return false.
                    TC -> O(n^2) // TLE
                    SC -> O(1)

        Approach 2. Better approach is to sort the array and just iterate from the second element and check if it is the same
                        element as the previous element if yes return true else return false.
                    TC -> O(n log n)
                    SC -> O(1)

        Approach 3. Using a set, we just iterate from the array from start and check if the set contains that word if yes
                        return true or else return false.
                    TC -> O(n)
                    SC -> O(n)
     */

    public static boolean containsDuplicate(int[] nums) {
        if(nums.length < 2) {
            return false;
        }

        Set<Integer> set = new HashSet<>();

        for(int num : nums) {
            if(set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,7,6,7,8}));
    }
}
