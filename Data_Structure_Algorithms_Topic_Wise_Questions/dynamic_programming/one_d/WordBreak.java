package Data_Structure_Algorithms_Topic_Wise_Questions.dynamic_programming.one_d;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public static boolean canBeWordSegmented(String str, int idx, Set<String> set, int[] dp) {
        if(idx >= str.length()) {
            return true;
        }

        if(dp[idx] != -1) {
            return dp[idx] == 1;
        }

        for(int i=idx+1; i<=str.length(); i++) {
            String sub = str.substring(idx, i);
            if(set.contains(sub) && canBeWordSegmented(str, i, set, dp)) {
                dp[idx] = 1;
                return true;
            }
        }
        dp[idx] = 0;
        return false;
    }

    public static boolean wordBreak(String str, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int[] dp = new int[str.length()+1];
        Arrays.fill(dp, -1);
        return canBeWordSegmented(str, 0, set, dp);
    }

    public static void main(String[] args) {
        List<String> words = List.of("cats","dog","sand","and","cat");
        System.out.println(wordBreak("catsandog", words));
    }
}
