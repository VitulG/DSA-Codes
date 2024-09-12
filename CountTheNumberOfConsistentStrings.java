import java.util.HashSet;
import java.util.Set;

public class CountTheNumberOfConsistentStrings {

    public static int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();

        for(char ch : allowed.toCharArray()) {
            set.add(ch);
        }

        int consistentStrings = 0;

        for(String word : words) {
            boolean flag = true;

            for(char ch : word.toCharArray()) {
                if(!set.contains(ch)) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                consistentStrings++;
            }
        }
        return consistentStrings;
    }

    public static void main(String[] args) {
        System.out.println(countConsistentStrings("ab", new String[]{"ad","bd","aaab","baa","badab"}));
    }
}
