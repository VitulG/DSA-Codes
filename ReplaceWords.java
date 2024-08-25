import java.util.ArrayList;
import java.util.List;

public class ReplaceWords {
    static class TrieNode {
        char ch;
        TrieNode[] childrens;
        boolean isCompleted;

        public TrieNode(char ch) {
            this.ch = ch;
            childrens = new TrieNode[26];
            isCompleted = false;
        }
    }

    static TrieNode root = new TrieNode('-');

    public static void insert(String word) {
        TrieNode curr = root;

        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if(curr.childrens[ch-'a'] == null) {
                curr.childrens[ch-'a'] = new TrieNode(ch);
            }
            curr = curr.childrens[ch-'a'];
        }
        curr.isCompleted = true;

    }

    public static String searchWord(String word) {
        TrieNode curr = root;
        StringBuilder shortWord = new StringBuilder("");

        for(char ch : word.toCharArray()) {
            if(curr.childrens[ch-'a'] == null) {
                return null;
            }
            shortWord.append(ch);
            curr = curr.childrens[ch-'a'];

            if(curr.isCompleted) {
                return shortWord.toString();
            }
        }
        return null;
    }

    public static String replaceWords(List<String> dictionary, String sentance) {
        for(String word : dictionary) {
            insert(word);
        }

        String[] words = sentance.split(" ");
        StringBuilder ans = new StringBuilder("");

        for(String word : words) {
            String foundWord = searchWord(word);

            if(foundWord == null) {
                ans.append(word);
            }else{
                ans.append(foundWord);
            }
            ans.append(" ");
        }
        return ans.toString().trim();
    }

    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<String>();
        dictionary.add("a");
        dictionary.add("ab");
        dictionary.add("abc");
        dictionary.add("abcd");
        System.out.println(replaceWords(dictionary, "abc ddf fejdk a bc dci fksj"));
    }
    
}
