package Data_Structure_Algorithms_Topic_Wise_Questions.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class SubstringsWithKDistinct {

    /*
        Approach 1. Brute force, Generate all the substring and check which substrings contains exactly k distinct
                        chars.
                    TC -> O(n^3)
                    SC -> O(n)

        Approach 2. Using Sliding window technique, we will use the formula if we find out the exact number of k substrings
                        we know how many at most k and k-1 substring is there if we find out then simple apply the formula
                        exactly k substring = utmost k substrings - utmost k-1 substrings return their subtraction.
                        for finding utmost k substrings, we can use a map of 26 character maximum stores and use a sliding
                        window if the substring length <= k then just count the character length from right to left and
                        return those substrings.
                    TC -> O(n)
                    SC -> O(26)
     */
    
    public static int countSubstringUtmostK(String str, int k) {
        int left = 0;
        int right = 0;

        int substrings = 0;
        Map<Character, Integer> map = new HashMap<>();

        while(right < str.length()) {
            char rightChar = str.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

            while(map.size() > k) {
                char leftChar = str.charAt(left);
                int count = map.get(leftChar) - 1;
                map.put(leftChar, count);

                if(count == 0) {
                    map.remove(leftChar);
                }
                left++;
            }
            substrings += (right - left + 1);
            right++;
        }
        return substrings;
    }

    public static int countSubstr(String s, int k) {
        if(s.isEmpty() || k == 0) {
            return 0;
        }
        
        return countSubstringUtmostK(s, k) - countSubstringUtmostK(s, k-1);
    }

    public static void main(String[] args) {
        System.out.println(countSubstr("abcba", 2));
    }
}
