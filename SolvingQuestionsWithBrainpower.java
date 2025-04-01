import java.lang.reflect.Array;
import java.util.Arrays;

public class SolvingQuestionsWithBrainpower {

    public static long generateMaximumPoints(int[][] questions, int idx, long[] dp) {
        if(idx >= questions.length) {
           return 0L;
        }

        if(dp[idx] != -1) {
            return dp[idx];
        }

        // not take any question
        long skipQuestionPoints = generateMaximumPoints(questions, idx+1, dp);

        // if I can take
        long solvedQuestionPoints = questions[idx][0] + generateMaximumPoints(questions, idx + questions[idx][1] + 1, dp);

        return dp[idx] = Math.max(skipQuestionPoints, solvedQuestionPoints);
    }

    public static long mostPoints(int[][] questions) {
        if(questions.length == 0) {
            return 0;
        }
        long[] dp = new long[questions.length+1];
        Arrays.fill(dp, -1);

        return generateMaximumPoints(questions, 0, dp);
    }

    public static void main(String[] args) {
        System.out.println(mostPoints(new int[][]{
                {3,2},
                {4,3},
                {4,4},
                {2,5}
        }));
    }
}
