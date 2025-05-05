package Data_Structure_Algorithms_Topic_Wise_Questions.bit_manipulation;

public class NumberOfOneBits {

    /*
        Approach:
            - Use bit manipulation to count set bits in the binary representation.
            - Using Brian Kernighan’s Algorithm reduces unnecessary iterations.

            Time Complexity: O(maxBits)
            Space Complexity: O(1)
    */

    public static int hammingWeight(int n) {
        if(n == 0) {
            return 0;
        }

        int maxBits = 0;
        int temp = n;

        while(temp != 0) {
            maxBits++;
            temp >>= 1;
        }

        int oneBits = 0;

        for(int i=0; i<=maxBits; i++) {
            if((n&(1<<i)) != 0) {
                oneBits++;
            }
        }
        return oneBits;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(2147483645));
    }
}
