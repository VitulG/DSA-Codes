package Data_Structure_Algorithms_Topic_Wise_Questions.arrays_strings;

public class ReverseVowelsOfAString {

    public static boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }

    public static String reverseVowels(String str) {
        if(str == null || str.isEmpty()) {
            return "";
        }

        int left = 0;
        int right = str.length() - 1;

        char[] strChars = str.toCharArray();

        while(left <= right) {
            char leftCh = strChars[left];
            char rightCh = strChars[right];

            if(isVowel(leftCh) && isVowel(rightCh)) {
                char ch = strChars[left];
                strChars[left] = strChars[right];
                strChars[right] = ch;
                left++;
                right--;
            }
            if(!isVowel(leftCh)) {
                left++;
            }

            if(!isVowel(rightCh)) {
                right--;
            }
        }
        return new String(strChars);
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("hellothisisVitulGupta"));
    }
}
