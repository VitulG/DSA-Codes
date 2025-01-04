import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniqueLengthThreePalindromicSubsequences {

    public static boolean isPalindromicSubsequence(String str) {
        return str.charAt(0) == str.charAt(2);
    }

    public static void backtrack(String str, int idx, StringBuilder currStr,
                                                             Set<String> set) {
        if(currStr.length() == 3) {
            if(isPalindromicSubsequence(currStr.toString())) {
                set.add(currStr.toString());
            }
            return;
        }

        if(idx >= str.length()) {
            return;
        }

        currStr.append(str.charAt(idx));
        backtrack(str, idx+1, currStr, set);
        currStr.deleteCharAt(currStr.length()-1);
        backtrack(str, idx+1, currStr, set);

    }

    public static int countPalindromicSubsequence(String str) {
        if(str == null || str.length() < 3) {
            return 0;
        }

        Set<Character> letters = new HashSet<>();

        for(char ch : str.toCharArray()) {
            letters.add(ch);
        }

        int uniquePalindromicSubsequences = 0;

        for(char ch : letters) {
            int chLeftIdx  = -1;
            int chRightIdx = -1;

            for(int i=0; i<str.length(); i++) {
                if(str.charAt(i) == ch) {
                    if(chLeftIdx == -1) {
                        chLeftIdx = i;
                    }
                    chRightIdx = i;
                }
            }

            Set<Character> uniqueChars = new HashSet<>();

            for(int m = chLeftIdx+1; m <= chRightIdx-1; m++) {
                uniqueChars.add(str.charAt(m));
            }
            uniquePalindromicSubsequences += uniqueChars.size();
        }
        return uniquePalindromicSubsequences;
    }

    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequence("aabca"));
    }
}
