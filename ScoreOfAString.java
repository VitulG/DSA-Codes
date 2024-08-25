public class ScoreOfAString {

    public static int scoreOfString(String str) {
        int score = 0;

        for(int i=0; i<str.length()-1; i++) {
            int diff = Math.abs(str.charAt(i) - str.charAt(i+1));
            score += diff;
        }
        return score;
    }

    public static void main(String[] args) {
        System.out.println(scoreOfString("zaz"));
    }
}
