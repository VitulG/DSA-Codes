import java.util.HashMap;
import java.util.Map;

public class FindLongestSpecialSubstringThatOccursThriceI {

    public static boolean isSpecialSubstring(String str) {
        char firstChar = str.charAt(0);
        for(char ch : str.toCharArray()) {
            if(ch != firstChar) {
                return false;
            }
        }
        return true;
    }

    public static int maximumLength(String str) {
        if(str == null || str.isEmpty()) {
            return 0;
        }

        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<str.length(); i++) {
            StringBuilder currSub = new StringBuilder();
            for(int j=i; j<str.length(); j++) {
                currSub.append(str.charAt(j));

                String substring = currSub.toString();

                if(isSpecialSubstring(substring)) {
                    map.put(substring, map.getOrDefault(substring, 0)+1);
                }
            }
        }

        int maxLength = Integer.MIN_VALUE;

        for(String key : map.keySet()) {
            if(map.get(key) >= 3) {
                maxLength = Math.max(maxLength, key.length());
            }
        }
        return maxLength == Integer.MIN_VALUE ? -1 : maxLength;
    }

    public static void main(String[] args) {
        System.out.println(maximumLength("abcaba"));
    }
}
