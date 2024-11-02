public class CircularSentence {

    public static boolean isCircularSentence(String sentence) {
        if(sentence == null || sentence.isEmpty()) {
            return true;
        }

        String[] words = sentence.split(" ");

        if(words[0].charAt(0) != words[words.length-1].charAt(words[words.length-1].length()-1)) {
            return false;
        }

        for(int i=1; i<words.length; i++) {
            String prevWord = words[i-1];
            String currWord = words[i];
            if(prevWord.charAt(prevWord.length()-1) != currWord.charAt(0)) {
                return false;
            }
        }

        String lastWord = words[words.length-1];
        String firstWord = words[0];

        return lastWord.charAt(lastWord.length() - 1) == firstWord.charAt(0);
    }

    public static void main(String[] args) {
        System.out.println(isCircularSentence("Leetcode is cool"));
    }
}
