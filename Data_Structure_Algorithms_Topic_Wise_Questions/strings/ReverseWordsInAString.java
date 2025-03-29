package Data_Structure_Algorithms_Topic_Wise_Questions.strings;

public class ReverseWordsInAString {

    public static void reverseWordsArray(String[] words, int st, int en) {
        while(st < en) {
            String word = words[st];
            words[st] = words[en];
            words[en] = word;
            st++;
            en--;
        }
    }

    public static String reverseWords(String str) {
        if(str.isEmpty()) {
            return "";
        }

        if(str.length() == 1) {
            return str;
        }

        str = str.trim();
        String[] words = str.split("\\s+");

        reverseWordsArray(words, 0, words.length-1);

        StringBuilder reverseString = new StringBuilder();

        for(int i=0; i<words.length; i++) {
            if(i == words.length-1) {
                reverseString.append(words[i]);
            }else {
                reverseString.append(words[i]).append(" ");
            }
        }
        return reverseString.toString();

    }

    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world  "));
    }
}
