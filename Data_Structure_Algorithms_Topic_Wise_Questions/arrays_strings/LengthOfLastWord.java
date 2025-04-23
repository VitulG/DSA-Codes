package Data_Structure_Algorithms_Topic_Wise_Questions.arrays_strings;

public class LengthOfLastWord {

    public static int lengthOfLastWord(String str) {
        // Approach 1. remove the whitespaces from the right
        int idx = str.length()-1;

        while(idx >= 0 && str.charAt(idx) == ' ') {
            idx--;
        }

        int lastWordLength = 0;

        while(idx >= 0 && str.charAt(idx) != ' ') {
            lastWordLength++;
            idx--;
        }
        return lastWordLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
    }
}
