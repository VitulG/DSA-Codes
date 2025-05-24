package Data_Structure_Algorithms_Topic_Wise_Questions.hashing;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    /*
        Approach:
            Use two hash maps to track character mappings both ways (s → t and t → s).
            If at any point the mapping breaks (existing key maps to a different value), return false.

            Time Complexity: O(n)
            Space Complexity: O(n) (for maps)
    */

    public static boolean isIsomorphic(String s, String t) {

        if(s.length() != t.length()) {
            return false;
        }

        int len = s.length();
        Map<Character, Character> sTot = new HashMap<>();
        Map<Character, Character> tTos = new HashMap<>();

        for(int i=0; i<len; i++) {
            char sch = s.charAt(i);
            char tch = t.charAt(i);

            if((sTot.containsKey(sch) && (sTot.get(sch) != tch)) ||
                    (tTos.containsKey(tch) &&(tTos.get(tch) != sch))) {
                return false;
            }
            sTot.put(sch, tch);
            tTos.put(tch, sch);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("foo", "bar"));
    }
}
