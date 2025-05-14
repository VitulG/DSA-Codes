package Data_Structure_Algorithms_Topic_Wise_Questions.bit_manipulation;

public class MinimumFlipsToMakeAORBEqualToC {

    /*
        Approach: - 1. Find the max number to make loop till that max bit.
                    2. Find the current ith bit of the a, b and c by dividing the number by ith times using
                            Right shift operator.
                    3. Now check if c ith pos has 1 bit, so we just need to check if either a or b will contain a set bit
                    4. Else, c has unset bit i.e., 0 if both a and b contain set bits we will count as +2 else we just count
                            either a or b has set bit or not and increase the count by those filips.
                    TC -> O(maxBits)
                    SC -> O(1)
     */

    public static int minFlips(int a, int b, int c) {
        int maxNumber = Math.max(a, Math.max(b, c));

        int maxBits = 0;

        while(maxNumber != 0) {
            maxBits++;
            maxNumber >>= 1;
        }

        int minFlips = 0;

        for(int i=0; i<=maxBits; i++) {
            int aIthBit = (a >> i) & 1;
            int bIthBit = (b >> i) & 1;
            int cIthBit = (c >> i) & 1;

            int aORb = aIthBit | bIthBit;

            if(aORb == cIthBit) {
                continue;
            }

            int flips = 0;

            if(cIthBit == 0) {
                if(aIthBit == 1) {
                    flips++;
                }

                if(bIthBit == 1) {
                    flips++;
                }
                minFlips += flips;
            }else {
                minFlips+=1;
            }

        }
        return minFlips;
    }

    public static void main(String[] args) {
        System.out.println(minFlips(4,5,6));
    }
}
