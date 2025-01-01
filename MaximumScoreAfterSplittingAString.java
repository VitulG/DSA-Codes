public class MaximumScoreAfterSplittingAString {

    public static int countZeros(String leftSubstring) {
        int zeros = 0;

        for(char ch : leftSubstring.toCharArray()) {
            if(ch == '0') {
                zeros++;
            }
        }
        return zeros;
    }

    public static int countOnes(String rightSubstring) {
        int ones = 0;

        for(char ch : rightSubstring.toCharArray()) {
            if(ch == '1') {
                ones++;
            }
        }
        return ones;
    }

    public static int maxScore(String str) {
        if(str == null || str.isEmpty()) {
            return 0;
        }

        int maxScore = Integer.MIN_VALUE;

        for(int i=1; i<str.length(); i++) {
            maxScore = Math.max(countZeros(str.substring(0, i)) + countOnes(str.substring(i)), maxScore);
        }
        return maxScore;
    }
    // Time Complexity => O(n^2), Optimal Solution will be using Prefix Sum with linear time O(n)
    // Space Complexity => O(1)

    public static void main(String[] args) {
        System.out.println(maxScore("011101"));
    }
}
