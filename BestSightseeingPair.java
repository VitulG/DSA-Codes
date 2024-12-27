public class BestSightseeingPair {

    public static int maxScoreSightseeingPair(int[] values) {
        int maxScore = Integer.MIN_VALUE;
        int maxTill = Integer.MIN_VALUE;

        for(int j=1; j<values.length; j++) {
            maxTill = Math.max(maxTill, values[j-1] + j-1);
            maxScore = Math.max(maxScore, maxTill + values[j] - j);
        }
        return maxScore;
    }

    public static void main(String[] args) {
        System.out.println(maxScoreSightseeingPair(new int[]{8,1,5,2,6}));
    }
}
