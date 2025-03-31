import java.util.Arrays;

public class PutMarblesInBags {

    public static long putMarbles(int[] weights, int k) {
        // step 1. calculate preWeights to get the preCalculate Adjacent sum to main substring condition
        int[] preWeights = new int[weights.length-1];

        for(int i=0; i<preWeights.length; i++) {
            preWeights[i] = weights[i] + weights[i+1];
        }

        // step 2. sort the array to get min and max easily
        Arrays.sort(preWeights);

        // step 3. get Min and max;
        long min = 0L;

        for(int i=0; i<k-1; i++) {
            min += preWeights[i];
        }

        long max = 0L;

        for(int i = preWeights.length-1; i > preWeights.length - k; i--) {
            max += preWeights[i];
        }

        return max - min;

    }

    public static void main(String[] args) {
        System.out.println(putMarbles(new int[]{2, 7, 4, 9, 5}, 3));
    }
}
