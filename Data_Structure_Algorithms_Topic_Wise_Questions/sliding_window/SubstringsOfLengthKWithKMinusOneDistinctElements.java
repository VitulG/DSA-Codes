package Data_Structure_Algorithms_Topic_Wise_Questions.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class SubstringsOfLengthKWithKMinusOneDistinctElements {

    /*
        Approach 1: Brute Force
        -----------------------
            - Generate all possible substrings.
            - For each substring, check if its length is exactly 'k'.
            - Use a helper function to check whether it contains exactly (k - 1) distinct characters.
            - If yes, increment the valid substring count.

        Time Complexity  : O(n^3)   // O(n^2) for substrings, O(k) for checking distinct chars
        Space Complexity : O(1)     // No extra space used apart from constant helper structures


        Approach 2: Sliding Window + HashMap
        -------------------------------------
            - Use a sliding window of fixed size 'k'.
            - Maintain a HashMap to track the frequency of characters in the current window.
            - For the first window, build the frequency map and check if it has (k - 1) keys.
            - Then, slide the window one character at a time:
                - Remove the outgoing character from the map.
                - Add the incoming character.
                - After each shift, check if map.size() == (k - 1), and if so, increment the count.

        Time Complexity  : O(n)
        Space Complexity : O(1)     // At most 26 lowercase letters, hence considered constant
     */

    public static int subStrCount(String s, int k) {
        if(s.isEmpty()) {
            return 0;
        }

        int substrings = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<k; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }

        if(map.size() == k-1) {
            substrings++;
        }

        for(int i=k; i<s.length(); i++) {
            char out = s.charAt(i-k);
            char in = s.charAt(i);

            int outCount = map.getOrDefault(out, 0);
            map.put(out, outCount-1);

            if(map.get(out) == 0) {
                map.remove(out);
            }
            map.put(in, map.getOrDefault(in, 0)+1);

            if(map.size() == k-1) {
                substrings++;
            }
        }
        return substrings;
    }

    public static void main(String[] args) {
        System.out.println(subStrCount("aabab", 3));
    }
}
