import java.util.HashMap;
import java.util.Map;

public class NumberOfSubstringsContainingAllThreeCharacters {

    public static int numberOfSubstrings(String str) {
        if(str.length() < 3) {
            return 0;
        }

        int le = 0;
        int ri = 0;

        Map<Character, Integer> map = new HashMap<>();
        int substrings = 0;

        while(ri < str.length()) {
            char rightChar = str.charAt(ri);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

            while(map.size() == 3) {
                substrings += (str.length() - ri);
                char leftChar = str.charAt(le);
                map.put(leftChar, map.get(leftChar) - 1);
                if(map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                le++;
            }
            ri++;
        }
        return substrings;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("aaacb"));
    }
}
