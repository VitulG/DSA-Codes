import java.util.Arrays;

public class MaximizeHappinessOfSelectedChildren {

    public static long maximumHappinessSum(int[] happiness, int k) {
        if(happiness.length == 1) {
            return happiness[0];
        }

        Arrays.sort(happiness);

        int start = happiness.length-1;
        long maxHappiness = 0l;

        while(k-- > 0) {
            happiness[start] = Math.max(happiness[start] - (happiness.length-1-start), 0);
            maxHappiness += happiness[start];
            start--;
        }
        return maxHappiness;

    }

    public static void main(String[] args) {
        System.out.println(maximumHappinessSum(new int[]{1,2,3}, 2));
    }
}