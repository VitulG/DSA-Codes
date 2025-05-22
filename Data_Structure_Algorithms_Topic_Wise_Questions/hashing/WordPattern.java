package Data_Structure_Algorithms_Topic_Wise_Questions.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {

    /*
        Approach is simple, just use a map and a set to keep track of the used mapping and used words.
                1. If a map contains that character just to ensure that only that value is the same with the current
                        ith word.
                2. If no, before map a character from pattern with a word we also ensures that a word must not be used
                        before.

                TC -> O(n)
                SC -> O(n)
     */

    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split("\\s+");

        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        if(pattern.length() != words.length) {
            return false;
        }

        for(int i=0; i<pattern.length(); i++) {
            if(map.containsKey(pattern.charAt(i))) {
                if(!map.get(pattern.charAt(i)).equals(words[i])) {
                    return false;
                }
            }else {
                if(set.contains(words[i])) {
                    return false;
                }
                map.put(pattern.charAt(i), words[i]);
                set.add(words[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
    }
}
