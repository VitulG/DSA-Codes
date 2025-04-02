package Data_Structure_Algorithms_Topic_Wise_Questions.recursion;

import java.util.ArrayList;

public class PossibleWordsFromPhoneDigits {

    public static void generatePossibleWords(int[] arr, int idx, StringBuilder curr, ArrayList<String> generatedWords,
                                             String[] words) {
        if(idx >= arr.length) {
            generatedWords.add(curr.toString());
            return;
        }

        String currentNumberString = words[arr[idx]];

        for(int i=0; i<currentNumberString.length(); i++) {
            curr.append(currentNumberString.charAt(i));
            generatePossibleWords(arr, idx+1, curr, generatedWords, words);
            curr.deleteCharAt(curr.length()-1);
        }
    }

    public static ArrayList<String> possibleWords(int[] arr) {
        String[] words = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        ArrayList<String> generatedWords = new ArrayList<>();
        generatePossibleWords(arr, 0, new StringBuilder(), generatedWords, words);

        return generatedWords;
    }

    public static void main(String[] args) {
        System.out.println(possibleWords(new int[]{3,4,5}));
    }
}
