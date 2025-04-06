package Data_Structure_Algorithms_Topic_Wise_Questions.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKUniques {

    public static int longestkSubstr(String s, int k) {
        if(s.isEmpty()) {
            return 0;
        }

        int le = 0;
        int ri = 0;

        Map<Character, Integer> map = new HashMap<>();

        int longestSubstring = Integer.MIN_VALUE;

        while(ri < s.length()) {
            char ch = s.charAt(ri);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if (map.size() == k) {
                longestSubstring = Math.max(longestSubstring, ri - le + 1);
            }

            if (map.size() > k) {
                while (map.size() > k) {
                    char leftChar = s.charAt(le);
                    int count = map.get(leftChar) - 1;

                    if (count == 0) {
                        map.remove(leftChar);
                    } else {
                        map.put(leftChar, count);
                    }
                    le++;
                }
            }
            ri++;
        }
        return longestSubstring == Integer.MIN_VALUE ? -1 : longestSubstring;
    }

    public static void main(String[] args) {
        System.out.println(longestkSubstr("aabaaab", 2));
    }
}
