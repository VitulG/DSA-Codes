public class CheckIfAWordOccursAsAPrefixOfAnyWordInASentence {

    public static int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");

        int i = 1;
        for(String word : words) {
            int minLength = Math.min(word.length(), searchWord.length());

            int idx = 0;
            while(idx < minLength) {
                if(word.charAt(idx) == searchWord.charAt(idx)) {
                    idx++;
                }else{
                    break;
                }
            }
            if(idx == searchWord.length()) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(isPrefixOfWord("i am tired", "you"));
    }
}
