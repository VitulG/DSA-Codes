package Data_Structure_Algorithms_Topic_Wise_Questions.sliding_window;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    /*
        Approach 1 Brute force, generate all the substrings and check if a substring is without repeating chars
                        if yes, we just need to check the maximum substring and return their length.
                    TC -> O(n^3)
                    SC -> O(1)

        Approach 2 Using Hashing and Sliding window just iterate from left to right and add right characters in a set
                    and check the maximum length of a substring if the right character is there in a set, we need to shrink
                    the left window and go to till string length and return the maximized substring length.
                    TC -> O(n)
                    SC -> O(n)
     */

    public static int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) {
            return 0;
        }

        int left = 0;
        int right = 0;

        Set<Character> set = new HashSet<>();
        int longestSubstring = Integer.MIN_VALUE;

        while(right < s.length()) {
            if(!set.contains(s.charAt(right))) {
                longestSubstring = Math.max(longestSubstring, right - left + 1);
                set.add(s.charAt(right));
            }else {
                while(s.charAt(left) != s.charAt(right)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
            right++;
        }
        return longestSubstring;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
