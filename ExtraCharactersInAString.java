import java.util.*;

public class ExtraCharactersInAString {

    public static int getMinimumExtraCharacters(String s, int index, Set<String> set, int[] dp) {
        if(index >= s.length()) {
            return 0;
        }

        if(dp[index] != -1) {
            return dp[index];
        }

        StringBuilder curr = new StringBuilder();
        int extraChars = Integer.MAX_VALUE;

        for(int i=index; i<s.length(); i++) {
            curr.append(s.charAt(i));
            int currExtra = (set.contains(curr.toString())) ? 0 : curr.length();
            int nextExtra = getMinimumExtraCharacters(s, i+1, set, dp);

            int totalExtra = currExtra + nextExtra;

            extraChars = Math.min(extraChars, totalExtra);
        }
        return dp[index] = extraChars;
    }

    public static int minExtraChar(String s, String[] dictionary) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);

        Set<String> set = new HashSet<String>(Arrays.asList(dictionary));
        return getMinimumExtraCharacters(s, 0, set, dp);
    }

    public static void main(String[] args) {
        String[] dictionary = {"leet", "code", "leetcode"};

        System.out.println(minExtraChar("leetscode", dictionary));
    }
}
