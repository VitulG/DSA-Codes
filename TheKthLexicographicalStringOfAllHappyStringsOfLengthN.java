import java.util.ArrayList;
import java.util.List;

public class TheKthLexicographicalStringOfAllHappyStringsOfLengthN {

    public static void generateHappyStrings(List<String> happyStrings, StringBuilder currString,int idx, int len) {
        if(idx >= len) {
            happyStrings.add(currString.toString());
            return;
        }

        for(char ch : "abc".toCharArray()) {
            if(idx == 0 || currString.charAt(idx-1) != ch) {
                currString.append(ch);
                generateHappyStrings(happyStrings, currString, idx+1, len);
                currString.deleteCharAt(currString.length()-1); // backtrack
            }
        }
    }

    public static String getHappyString(int n, int k) {
        List<String> happyStrings = new ArrayList<>();
        generateHappyStrings(happyStrings, new StringBuilder(), 0, n);

        if(k > happyStrings.size()) {
            return "";
        }

        return happyStrings.get(k-1);
    }

    public static void main(String[] args) {
        System.out.println(getHappyString(3, 9));
    }
}
