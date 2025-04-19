package Data_Structure_Algorithms_Topic_Wise_Questions.hashing;

import java.util.HashSet;
import java.util.Set;

public class FindOnlyRepetitiveElement {

    public static int findDuplicate(int[] arr) {
        // Approach 1. check every element in the array if it appears twice or not if yes return straightaway
        // TC -> O(n^2), SC -> O(1)

        // Approach 2. using Hashing, we will put every element in the set if the set contains the element, then return the element
        // TC -> O(n), SC -> O(n)

        Set<Integer> set = new HashSet<>();

        for(int num : arr) {
            if(set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;

        // Approach 3. we can further optimize the space complexity by using XOR operation
        // TC -> O(n), SC -> O(1)
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1, 5, 1, 2, 3, 4}));
    }
}
