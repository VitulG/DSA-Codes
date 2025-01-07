import java.util.ArrayList;
import java.util.List;

public class StringMatchingInAnArray {

    public static List<String> stringMatching(String[] words) {
        List<String> matchedSubstrings = new ArrayList<>();

        for(int i=0; i<words.length; i++) {
            boolean isFound = false;
            for(int j=0; j< words.length; j++) {
                if(i != j && words[j].contains(words[i])) {
                    isFound = true;
                    break;
                }
            }
            if(isFound) {
                matchedSubstrings.add(words[i]);
            }
        }
        return matchedSubstrings;
    }

    // TC of this approach will be O(n^2) // for nested loops and O(m) length of the next string
    // TC => O(n*n*m)
    // SC => O(1)

    public static void main(String[] args) {
        System.out.println(stringMatching(new String[]{"blue","green","bu"}));
    }
}
