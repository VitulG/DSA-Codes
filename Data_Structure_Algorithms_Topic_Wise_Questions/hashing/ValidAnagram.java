package Data_Structure_Algorithms_Topic_Wise_Questions.hashing;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    /*
        Approach 1. Brute force approach check each character of s in String t if that character not present return false
                        return true.

                    TC -> O(n*m)
                    SC -> O(1)

        Approach 2. Using hashing, use a frequency array or map to store the character frequency and check if the t string
                        character is present or not if not return false else return true.

                    TC -> O(n + m)
                    SC -> O(n)
     */

    public static boolean isAnagram(String s, String t) {
        int[] sf = new int[26];
        int[] tf = new int[26];

        for(char ch : s.toCharArray()) {
            sf[ch-'a']++;
        }

        for(char ch : t.toCharArray()) {
            tf[ch-'a']++;
        }

        for(int i=0; i<26; i++) {
            if(sf[i] != tf[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagramWithUnicodeSupport(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(char ch : t.toCharArray()) {
            if(!map.containsKey(ch)) {
                return false;
            }
            map.put(ch, map.get(ch)-1);

            if(map.get(ch) == 0) {
                map.remove(ch);
            }
        }
        return map.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("racecar", "cartrar"));
        System.out.println(isAnagramWithUnicodeSupport("anagram", "nagaram"));
    }
}
