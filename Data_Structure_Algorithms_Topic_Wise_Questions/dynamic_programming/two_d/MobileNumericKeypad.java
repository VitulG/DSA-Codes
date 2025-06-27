package Data_Structure_Algorithms_Topic_Wise_Questions.dynamic_programming.two_d;


import java.util.Arrays;

public class MobileNumericKeypad {

    public static int generateUniqueSequences(int num, int[][] keyPad, int button, int[][] dp) {
        if(num == 0) {
            return 1;
        }

        if(dp[num][button] != -1) {
            return dp[num][button];
        }

        int total = 0;

        for(int number : keyPad[button]) {
            total += generateUniqueSequences(num-1, keyPad, number, dp);
        }
        return dp[num][button] = total;
    }

    public static int getCount(int n) {
        if(n == 0) {
            return 0;
        }

        int[][] keyPad = {  {0,8},
                            {1,2,4},
                            {2,3,5,1},
                            {3,6,2},
                            {4,1,5,7},
                            {5,2,6,8,4},
                            {6,3,9,5},
                            {7,4,8},
                            {8,5,9,0,7},
                            {9,6,8}
                        };
        int total = 0;
        int[][] dp = new int[n+1][10];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for(int button=0; button<=9; button++) {
            total += generateUniqueSequences(n-1, keyPad, button, dp);
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(getCount(3));
    }
}
