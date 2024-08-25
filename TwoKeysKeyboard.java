import java.util.Arrays;

public class TwoKeysKeyboard {

    public static int getMinOperations(int num, int currA, int clipBoard, int[][] dp) {
        if(currA == num) {
            return 0;
        }

        if(currA > num) {
            return 1000000;
        }

        if(dp[currA][clipBoard] != -1) {
            return dp[currA][clipBoard];
        }

        int copyAllWithPaste = 2 + getMinOperations(num, currA+currA, currA, dp);
        int pasteOnly = 1 + getMinOperations(num, currA+clipBoard, clipBoard, dp);

        return dp[currA][clipBoard] = Math.min(pasteOnly, copyAllWithPaste);
    }

    public static int minSteps(int num) {
        if(num == 1) {
            return 0;
        }

        int[][] dp = new int[1001][1001];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return getMinOperations(num, 1, 1, dp) + 1;
    }

    public static void main(String[] args) {
        System.out.println(minSteps(15));
    }    
}
