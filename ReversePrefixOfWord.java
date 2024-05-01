public class ReversePrefixOfWord {

    public static String reversePrefix(String word, char ch) {
        int reverseTill = -1;

        for(int i=0; i<word.length(); i++) {
            char currCh = word.charAt(i);
            if(currCh == ch) {
                reverseTill = i;
                break;
            }
        }

        StringBuilder revWord = new StringBuilder(word);
        int left = 0;
        int right = reverseTill;

        while(left <= right) {
            char leftChar = revWord.charAt(left);
            char rightChar = revWord.charAt(right);

            revWord.setCharAt(left, rightChar);
            revWord.setCharAt(right, leftChar);

            left++;
            right--;

        }
        return revWord.toString();

    }

    public static void main(String[] args) {
        System.out.println(reversePrefix("abcdefd", 'd'));
    }
    
}
