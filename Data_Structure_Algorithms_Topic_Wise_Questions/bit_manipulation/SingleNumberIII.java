package Data_Structure_Algorithms_Topic_Wise_Questions.bit_manipulation;

import java.util.Arrays;

public class SingleNumberIII {

    public static int[] singleNumber(int[] nums) {
        if(nums.length < 2) {
            return new int[]{};
        }

        // Approach using xor in our solution
        // TC -> O(n) SC -> O(1)

        // Step 1. find the overall xor of the numbers in array
        int xor = 0;
        for(int num : nums) {
            xor ^= num;
        }

        // Step 2. find the first set Bit in the xor value
        int pos = -1;
        for(int i=0; i<32; i++) {
            if((xor&(1<<i)) != 0) {
                pos = i;
                break;
            }
        }

        int numberInSetGroup = 0;
        int numberInUnsetGroup = 0;

        for(int num : nums) {
            if((num&(1<<pos)) != 0) { // set bit at pos in set bit group main daalo
                numberInSetGroup ^= num;
            }else {
                numberInUnsetGroup ^= num;
            }
        }
        return new int[]{numberInSetGroup, numberInUnsetGroup};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(singleNumber(new int[]{3,3,4,9,1,1})));
    }
}
