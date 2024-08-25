import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class FindCommonCharacters {

    public static List<String> commonChars(String[] words) {
        int[] freq = new int[26];
        Arrays.fill(freq, Integer.MAX_VALUE);

        for(String word : words) {
            int[] temp = new int[26];
            String currWord = word;

            for(char ch : currWord.toCharArray()) {
                temp[ch-'a']+=1;
            }

            for(int i=0; i<26; i++) {
                freq[i] = Math.min(freq[i], temp[i]);
            }
        }

        List<String> ans = new ArrayList<String>();

        for(int i=0; i<26; i++) {
            while(freq[i]-- > 0) {
                ans.add((char) (i + 'a')+"");
            }
        }
        return ans;

    }


    public static void main(String[] args) {
        System.out.println(commonChars(new String[]{"vitul"}));
    }
}
