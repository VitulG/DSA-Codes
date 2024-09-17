import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UncommonWordsFromTwoSentences {
    public static String[] uncommonFromSentences(String s1, String s2) {
        String[] s1Words = s1.split("\\s");
        String[] s2Words = s2.split("\\s");

        Map<String, Integer> word1Count = new HashMap<>();

        for(String word : s1Words) {
            word1Count.put(word, word1Count.getOrDefault(word, 0) + 1);
        }

        for(String word : s2Words) {
            word1Count.put(word, word1Count.getOrDefault(word, 0) + 1);
        }

        List<String> uncommonWords = new ArrayList<>();

        for(Map.Entry<String, Integer> entry : word1Count.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();
            if(count == 1) {
                uncommonWords.add(word);
            }
        }
        return uncommonWords.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] ans = uncommonFromSentences("apple apple", "banana");

        for(String word : ans) {
            System.out.println(word);
        }
    }
}
