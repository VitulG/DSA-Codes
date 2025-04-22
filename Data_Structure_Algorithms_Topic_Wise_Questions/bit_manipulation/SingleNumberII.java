package Data_Structure_Algorithms_Topic_Wise_Questions.bit_manipulation;

public class SingleNumberII {

    public static int singleNumber(int[] nums) {
        int uniqueNumber = 0;

        // Approach 1. check every number if its single or not
        // TC -> O(n) and SC -> O(1)

        // Approach 2. using Map to store all the frequencies of the numbers present in the array
        // TC -> O(2N) and SC -> O(n)

        // Approach 3. Using Bit manipulation to count the no. Of the set bits in each position and check if the set bits is the multiple of 3
        // TC -> O(32*n) and SC -> O(1)

        for(int i=0; i<32; i++) {
            int setBits = 0;

            for(int num : nums) { // count the set bits in each position i by ANDing with the num bit which is present at ith position
                if((num&(1<<i)) != 0) {
                    setBits++;
                }
            }

            if(setBits % 3 != 0) { // set bit found so we can increment the count
                uniqueNumber |= (1<<i); // if the setBitCount is odd, that means we have a unique element which bit is set at the ith position
            }
        }
        return uniqueNumber;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{0,1,0,1,0,1,99}));
    }
}
