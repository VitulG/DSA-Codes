public class FindTheOriginalTypedStringI {

    public static int possibleStringCount(String word) {
        if(word.isEmpty()) {
            return 0;
        }

        int possibleStrings = 1;

        for(int i=1; i<word.length(); i++) {
            if(word.charAt(i) == word.charAt(i-1)) {
                possibleStrings++;
            }
        }
        return possibleStrings;
    }

    public static void main(String[] args) {
        System.out.println(possibleStringCount("ere"));
    }
}
