package Data_Structure_Algorithms_Topic_Wise_Questions.hashing;

import java.util.HashMap;
import java.util.Map;

public class VerifyingAnAlienDictionary {

    /*
        Approach: - We will use map to store which char occurred at which index in the order string and just check
                    1. if the first word char is less than the next word char, that means two words are sorted move to next
                    2. if the current two words are different we have to check if its prefix of the first word contains next
                          word so it can't be sorted return false.
                    3. if the char of the first > the next word char, that means words are not sorted return false.

                    TC -> O(n * Min(first, Second))
                    SC -> O(1)
     */

    public static boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        String first = words[0];

        for(int i=1; i<words.length; i++) {
            String next = words[i];

            if(first.length() > next.length() && first.startsWith(next)) {
                return false;
            }

            for(int j = 0; j< Math.min(first.length(), next.length()); j++) {
                char firstWordChar = first.charAt(j);
                char nextWordChar = next.charAt(j);

                if(map.get(firstWordChar) < map.get(nextWordChar)) {
                    break;
                }

                if(map.get(firstWordChar) > map.get(nextWordChar)) {
                    return false;
                }
            }
            first = next;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAlienSorted(new String[]{"apple","app"}, "abcdefghijklmnopqrstuvwxyz"));
    }
}
