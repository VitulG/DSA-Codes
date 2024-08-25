import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {

    public static void generateSentences(String str, int idx, StringBuilder currSentance, List<String> list, Set<String> dictionary) {
        if(idx >= str.length()) {
            list.add(currSentance.toString().trim());
            return;
        }

        for(int i = idx+1; i <= str.length(); i++) {
            String part = str.substring(idx, i);
            if(dictionary.contains(part)) {
                int originalLength = currSentance.length();
                currSentance.append(part).append(" ");
                generateSentences(str, i, currSentance, list, dictionary);
                currSentance.setLength(originalLength);
            }
        }
    }

    public static List<String> wordBreakII(String str, List<String> wordDict) {
        List<String> ans = new ArrayList<String>();
        Set<String> set = new HashSet<String>();


        for(String word : wordDict) {
            set.add(word);
        }
        generateSentences(str, 0, new StringBuilder(), ans, set);

        return ans;
    }

    public static void main(String[] args) {
        List<String> list = List.of("apple","pen","applepen","pine","pineapple");
        System.out.println(wordBreakII("pineapplepenapple", list));
    }
}
