package Data_Structure_Algorithms_Topic_Wise_Questions.two_pointers;

public class ReversePrefixOfWord {

    public static String reversePrefix(String word, char ch) {
        int reverseTill = -1;

        for(int i =0; i<word.length(); i++) {
            if(ch == word.charAt(i)) {
                reverseTill = i;
                break;
            }
        }

        if(reverseTill == -1) {
            return word;
        }

        char[] chars = word.toCharArray();
        int le = 0;
        int ri = reverseTill;

        while(le < ri) {
            char currentChar = chars[le];
            chars[le] = chars[ri];
            chars[ri] = currentChar;
            le++;
            ri--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(reversePrefix("abcdefd", 'd'));
    }
}
