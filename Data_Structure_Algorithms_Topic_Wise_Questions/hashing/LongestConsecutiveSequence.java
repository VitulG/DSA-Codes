package Data_Structure_Algorithms_Topic_Wise_Questions.hashing;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LongestConsecutiveSequence {


    /*
        Approach 1. Brute force approach, just check if nums array contain num+1 number in the array and take the max length
                        TC -> O(n^2)
                        SC -> O(1)

        Approach 2. Using Hashing, We can reduce the iteration using set put all the elements in the set and check if the
                        set contains num-1 number if yes that means this number is already part of the another consecutive
                        sequence so skip it or else make the consecutive length and return the maximum length.
                        TC -> O(n)
                        SC -> O(n)
     */
    public static int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }

        Iterator<Integer> it = set.iterator();
        int lcs = Integer.MIN_VALUE;

        while(it.hasNext()) {
            int num = it.next();

            if(!set.contains(num-1)) {
                int next = num+1;
                int length = 1;

                while(set.contains(next)) {
                    next +=1;
                    length+=1;
                }
                lcs = Math.max(lcs, length);
            }

        }
        return lcs == Integer.MIN_VALUE ? 0 : lcs;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{1,0,1,2}));
    }
}
