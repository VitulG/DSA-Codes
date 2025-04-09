package Data_Structure_Algorithms_Topic_Wise_Questions.sliding_window;

public class MaximumNumberOfVowelsInASubstringOfGivenLength {

    public static boolean isCharacterVowel(char ch) {
        return "aeiou".indexOf(ch) != -1;
    }

    public static int maxVowels(String str, int k) {
        int maxVowelsSubstring = Integer.MIN_VALUE;
        int vowelsSoFar = 0;

        for(int i=0; i<k; i++) {
            char ch = str.charAt(i);
            if(isCharacterVowel(ch)) {
                vowelsSoFar++;
            }
        }

        maxVowelsSubstring = vowelsSoFar;

        for(int i=k; i<str.length(); i++) {
            char prev = str.charAt(i-k);
            if(isCharacterVowel(prev)) {
                vowelsSoFar--;
            }

            char next = str.charAt(i);
            if(isCharacterVowel(next)) {
                vowelsSoFar++;
            }
            maxVowelsSubstring = Math.max(maxVowelsSubstring, vowelsSoFar);
        }
        return maxVowelsSubstring;
    }

    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef", 3));
    }
}
