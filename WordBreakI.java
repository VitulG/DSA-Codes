import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakI {

    public static boolean isWordBreak(String str, int idx, Set<String> words, Boolean[] dp) {
        if(idx >= str.length()) {
            return true;
        }

        if(words.contains(str)) {
            return true;
        }

        if(dp[idx] != null) {
            return dp[idx];
        }

        for(int i=idx+1; i<=str.length(); i++) {
            String part = str.substring(idx, i);
            if(words.contains(part) && isWordBreak(str, i, words, dp)) {
                return dp[idx] = true;
            }
        }
        return dp[idx] = false;

    }

    public static boolean wordBreak(String str, List<String> wordDict) {
        Set<String> words = new HashSet<String>();

        Boolean[] dp = new Boolean[str.length()+1];
        Arrays.fill(dp, null);

        for(String w : wordDict) {
            words.add(w);
        }

        return isWordBreak(str, 0, words, dp);
        
    }


    public static void main(String[] args) {
        List<String> list = List.of("cats","dog","sand","and","cat");
        System.out.println(wordBreak("catsandog", list));
    }  
}
