import java.util.ArrayList;
import java.util.List;

public class FindWordsContainingCharacter {

    public static List<Integer> findWordsContaining(String[] words, char x) {
        if(words.length == 0) {
            return new ArrayList<>();
        }

        List<Integer> ans = new ArrayList<>();

        int idx = 0;

        for(String word : words) {
            boolean isCharFound = false;
            for(char ch : word.toCharArray()) {
                if(ch == x) {
                    isCharFound = true;
                    break;
                }
            }
            if(isCharFound) {
                ans.add(idx);
            }
            idx++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findWordsContaining(new String[]{"leet","code"}, 'e'));
    }
}
