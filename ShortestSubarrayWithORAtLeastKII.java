public class ShortestSubarrayWithORAtLeastKII {
    public static void updateBits(int number, int[] setBits, int value) {
        for(int i=0; i<32; i++) {
            if(((number >> i & 1) != 0)) {
                setBits[i] += value;
            }
        }
    }

    public static int getDecimalNumber(int[] setBits) {
        int number = 0;

        for(int i=0; i<32; i++) {
            if(setBits[i] > 0) {
                number |= (1<<i);
            }
        }
        return number;
    }

    public static int minimumSubarrayLength(int[] nums, int k) {
        int length = Integer.MAX_VALUE;
        int le = 0;
        int ri = 0;

        int[] setBits = new int[32];

        while(ri < nums.length) {

            updateBits(nums[ri], setBits, 1);

            while(le <= ri && getDecimalNumber(setBits) >= k) {
                length = Math.min(length, ri - le + 1);
                updateBits(nums[le], setBits, -1);
                le++;
            }
            ri++;
        }
        return length == Integer.MAX_VALUE ? -1 : length;
    }

    public static void main(String[] args) {
        System.out.println(minimumSubarrayLength(new int[]{1,2,32,21}, 55));
    }
}
