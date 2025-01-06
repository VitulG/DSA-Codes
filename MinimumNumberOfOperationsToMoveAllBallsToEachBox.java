import java.util.Arrays;

public class MinimumNumberOfOperationsToMoveAllBallsToEachBox {

    public static int[] minOperations(String boxes) {
        int[] preLeftOnes = new int[boxes.length()];
        preLeftOnes[0] = boxes.charAt(0)-'0';

        for(int i=1; i<boxes.length(); i++) {
            preLeftOnes[i] = preLeftOnes[i-1] + (boxes.charAt(i)-'0');
        }

        int[] leftSum = new int[boxes.length()];
        int currSum = preLeftOnes[0];

        for(int i=1; i<boxes.length(); i++) {
            leftSum[i] = currSum;
            currSum += preLeftOnes[i];
        }

        int[] preRightOnes = new int[boxes.length()];
        preRightOnes[boxes.length()-1] = boxes.charAt(boxes.length()-1)-'0';

        for(int j = preRightOnes.length-2; j>=0; j--) {
            preRightOnes[j] = preRightOnes[j+1] + (boxes.charAt(j)-'0');
        }

        int[] rightSum = new int[boxes.length()];
        currSum = preRightOnes[preRightOnes.length-1];

        for(int j = rightSum.length-2; j>=0; j--) {
            rightSum[j] = currSum;
            currSum += preRightOnes[j];
        }

        int[] ans = new int[boxes.length()];

        for(int i =0; i<boxes.length(); i++) {
            ans[i] = leftSum[i] + rightSum[i];
        }

        return ans;
    }

    // Brute force solution TC => O(n^2) and SC => O(1)
    // Optimal Prefix solution TC => O(n) and SC => O(n) since we are using extra spaces

    public static void main(String[] args) {
        System.out.println(Arrays.toString(minOperations("1001110")));
    }
}
