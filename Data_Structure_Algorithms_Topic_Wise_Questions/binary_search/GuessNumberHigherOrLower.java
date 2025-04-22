package Data_Structure_Algorithms_Topic_Wise_Questions.binary_search;

import java.util.Random;

public class GuessNumberHigherOrLower {

    public static int guess(int guessedNumber, int chosenNumber) {
        return Integer.compare(chosenNumber, guessedNumber);
    }

    public static int guessNumber(int n, int picked) {
        int low = 1;
        int high = n;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            int value = guess(mid, picked);

            if(value == -1) {
                high = mid - 1;
            }else if(value == 0) {
                return mid;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int pickedNumber = new Random().nextInt(10) + 1;
        System.out.println(guessNumber(10, pickedNumber));
    }
}
