package Data_Structure_Algorithms_Topic_Wise_Questions.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

    /*
        The Approach here is to generate all the combination of two or more keypad values so we can use Backtracking here
             start with index 0 to length of the given digits and generate all the combinations

        TC -> O(4^n)
        SC -> O(length of digits)
     */

    public static void generateLetterCombinations(String digits, int idx, String[] keyPad, List<String> letterCombinations,
                                                  StringBuilder currCombination) {
        if(idx >= digits.length()) {
            letterCombinations.add(currCombination.toString());
            return;
        }

        int digit = digits.charAt(idx)-'0';
        String combination = keyPad[digit];

        for(int i=0; i<combination.length(); i++) {
            currCombination.append(combination.charAt(i));
            generateLetterCombinations(digits, idx+1, keyPad, letterCombinations, currCombination);
            currCombination.deleteCharAt(currCombination.length()-1);
        }
    }

    public static List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) {
            return new ArrayList<>();
        }

        String[] keyPad = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> letterCombinations = new ArrayList<>();

        generateLetterCombinations(digits, 0, keyPad, letterCombinations, new StringBuilder());

        return letterCombinations;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
