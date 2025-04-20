package Data_Structure_Algorithms_Topic_Wise_Questions.sliding_window;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

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
