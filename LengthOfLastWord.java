public class LengthOfLastWord {

    public static int lastWordLength(String str) {
        if(str.isEmpty() || str == null) {
            return 0;
        }

        int wordLen = str.length()-1;
        int lastWordLen = 0;

        while(wordLen >= 0 && str.charAt(wordLen) == ' ') {
            wordLen--;
        }

        while(wordLen >= 0 && str.charAt(wordLen) != ' ') {
            lastWordLen++;
            wordLen--;
        }
        return lastWordLen;

    }

    public static void main(String[] args) {
        System.out.println(lastWordLength("Hello my name is vitul gupta     g "));
    }
}