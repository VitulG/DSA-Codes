public class MinimumNumberOfOperationsToMakeArrayXOREqualToK {

    public static int minOperations(int[] nums, int k) {
        
        int totalXor = 0;
        
        for(int ele : nums) {
            totalXor ^= ele;
        }

        if(totalXor == k) {
            return 0;
        }

        int flip = 0;

        for(int i=31; i>=0; i--) {
            int xorBit = (totalXor&(1<<i));
            int kBit = (k&(1<<i));

            if(xorBit != kBit) {
                flip++;
            }
        }
        return flip;

    }

    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{2,0,2,0}, 0));
    }
}
