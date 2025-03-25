package Data_Structure_Algorithms_Topic_Wise_Questions.two_pointers;

public class ReverseVowelsOfAString {

    public static boolean isCharacterVowel(char ch) {
        return "AEIOUaeiou".indexOf(ch) != -1;
    }

    public static String reverseVowels(String str) {
        int le = 0;
        int ri = str.length()-1;

        char[] chars = str.toCharArray();

        while(le < ri) {
            if(isCharacterVowel(chars[le]) && isCharacterVowel(chars[ri])) {
                char ch = chars[le];
                chars[le] = chars[ri];
                chars[ri] = ch;
                le++;
                ri--;
            }

            if(!isCharacterVowel(chars[le])) {
                le++;
            }

            if(!isCharacterVowel(chars[ri])) {
                ri--;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("IceCreAm"));
    }
}
