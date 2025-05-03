package Data_Structure_Algorithms_Topic_Wise_Questions.sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SmallestDistinctWindow {

    /*
        Approach 1. to generate all the substring and check, which minimum substring has all the character
                    TC -> O(n^3), SC -> O(1)

        Approach 2. Using Hashing and Sliding window technique store and get the unique character size by using a set and
                        just check the size if the size is equal update the ans
                    TC -> O(n), SC -> O(n)
     */

    public static int findSubString(String str) {
        if(str.isEmpty()) {
            return 0;
        }

        Set<Character> set = new HashSet<>();
        for(char ch : str.toCharArray()) {
            set.add(ch);
        }

        int totalCharacters = set.size();
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;

        int smallestSubstringWindow = Integer.MAX_VALUE;

        while(right < str.length()) {
            map.put(str.charAt(right), map.getOrDefault(str.charAt(right), 0) + 1);

            while(map.size() == totalCharacters) {
                smallestSubstringWindow = Math.min(smallestSubstringWindow, right - left + 1);

                char leftCharacter = str.charAt(left);
                map.put(leftCharacter, map.get(leftCharacter) - 1);

                if(map.get(leftCharacter) == 0) {
                    map.remove(leftCharacter);
                }
                left++;
            }
            right++;
        }
        return smallestSubstringWindow == Integer.MAX_VALUE ? 0 : smallestSubstringWindow;
    }

    public static void main(String[] args) {
        System.out.println(findSubString("geeksforgeeks"));
    }
}
