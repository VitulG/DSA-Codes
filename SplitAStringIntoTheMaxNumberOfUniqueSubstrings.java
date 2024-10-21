import java.util.HashSet;
import java.util.Set;

public class SplitAStringIntoTheMaxNumberOfUniqueSubstrings {

    public static int generateUniqueSubstrings(String str, int idx, Set<String> set) {
        if(idx >= str.length()) {
            return 0;
        }

        int maxUniqueSubstring = 0;

        for(int i=idx; i<str.length(); i++) {
            String substring = str.substring(idx, i+1);
            if(!set.contains(substring)) {
                set.add(substring);
                int remaining = generateUniqueSubstrings(str, i+1, set) + 1;
                maxUniqueSubstring = Math.max(maxUniqueSubstring, remaining);
                set.remove(substring);
            }
        }
        return maxUniqueSubstring;
    }

    public static int maxUniqueSplit(String str) {
        if(str == null || str.isEmpty()) {
            return 0;
        }

        Set<String> set = new HashSet<>();
        return generateUniqueSubstrings(str, 0, set);
    }

    public static void main(String[] args) {
        System.out.println(maxUniqueSplit("ababccc"));
    }
}
