package Data_Structure_Algorithms_Topic_Wise_Questions.hashing;

import java.util.*;

public class GroupAnagrams {

    /*
        Approach:
            - To group all anagrams together, we use a hashmap.
            - The key will be the sorted version of each string.
            - Strings that are anagrams will have the same sorted version and go into the same list.

        Steps:
            1. Loop through all strings.
            2. Sort each string and use it as a key in a HashMap.
            3. Group the original strings under the same key.

        Time Complexity:
            - O(n * k log k), where:
                n = number of strings,
                k = maximum length of a string (due to sorting each string).

        Space Complexity:
            - O(n * k) for storing the grouped anagrams in the HashMap.
     */

    public static String getSortedWord(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            String sortedWord = getSortedWord(str);

            if(!map.containsKey(sortedWord)) {
                List<String> newAnagrams = new ArrayList<>();
                newAnagrams.add(str);
                map.put(sortedWord, newAnagrams);
            }else {
                List<String> existingAnagrams = map.get(sortedWord);
                existingAnagrams.add(str);
                map.put(sortedWord, existingAnagrams);
            }
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}
