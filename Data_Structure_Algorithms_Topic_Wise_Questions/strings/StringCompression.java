package Data_Structure_Algorithms_Topic_Wise_Questions.strings;

public class StringCompression {

    public static int compress(char[] chars) {
        if(chars.length == 0) {
            return 0;
        }

        if(chars.length == 1) {
            return 1;
        }

        int idx = 0;
        int i = 0;

        while (i < chars.length) {
            char ch = chars[i];
            int charCount = 0;

            while(i < chars.length && chars[i] == ch) {
                charCount++;
                i++;
            }

            chars[idx++] = ch;

            if(charCount > 1) {
                for(char num : String.valueOf(charCount).toCharArray()) {
                    chars[idx++] = num;
                }
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a','a','b','b','c','c','c','d'}));
    }
}
