package Data_Structure_Algorithms_Topic_Wise_Questions.two_pointers;

public class ReverseOnlyLetters {

    public static String reverseOnlyLetters(String str) {
        char[] chars = str.toCharArray();
        int le = 0;
        int ri = chars.length-1;

        while(le < ri) {
            if(Character.isLetter(chars[le]) && Character.isLetter(chars[ri])) {
                char ch = chars[le];
                chars[le] = chars[ri];
                chars[ri] = ch;
                le++;
                ri--;
            }

            if(!Character.isLetter(chars[le])) {
                le++;
            }

            if(!Character.isLetter(chars[ri])) {
                ri--;
            }
        }
        return  new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));
    }
}
