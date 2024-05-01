import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> mapST = new HashMap<Character, Character>();
        Map<Character, Character> mapTS = new HashMap<Character, Character>();

        for(int i=0; i<s.length(); i++) {
            char or = s.charAt(i);
            char re = t.charAt(i);

            if(mapST.containsKey(or)) {
                if(mapST.get(or) != re) {
                    return false;
                }
            }else{
                mapST.put(or,re);
            }

            if(mapTS.containsKey(re)) {
                if(mapTS.get(re) != or) {
                    return false;
                }
            }else{
                mapTS.put(re, or);
            }
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("badc", "kikp"));
    }
}