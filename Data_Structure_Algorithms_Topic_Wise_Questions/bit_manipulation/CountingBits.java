package Data_Structure_Algorithms_Topic_Wise_Questions.bit_manipulation;

import java.util.Arrays;

public class CountingBits {

    // Approach 1. using bits and check for how many set bits are there in one number
    // TC -> O(n log n), SC -> O(n)

    public static int getNumberSetBits(int number, int maxBits) {
        int setBits = 0;

        for(int i=0; i<maxBits; i++) {
            if((number&(1<<i)) != 0) {
                setBits++;
            }
        }
        return setBits;
    }

    public static int[] countBits(int n) {
        int[] ans = new int[n+1];

        int temp = n;
        int maxBits = 0;

        while(temp != 0) {
            maxBits++;
            temp /= 2;
        }

        for(int i=0; i<=n; i++) {
            int setBits = getNumberSetBits(i, maxBits);
            ans[i] = setBits;
        }
        return ans;
    }

    //Approach 2. we can use DP here we can use the previous result bits for their upcoming number bits
    // TC -> O(n), SC -> O(1)

    public static int[] countBitsUsingDP(int n) {
        if(n == 0) {
            return new int[]{0};
        }

        int[] ans = new int[n+1];
        ans[0] = 0;
        ans[1] = 1;

        for(int i=2; i<=n; i++) {
            ans[i] = ans[i >> 1] + (i&1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
        System.out.println(Arrays.toString(countBitsUsingDP(0)));
    }
}
