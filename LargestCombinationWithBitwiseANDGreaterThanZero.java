public class LargestCombinationWithBitwiseANDGreaterThanZero {

    private static boolean isSetBit(int num, int idx) {
        return (num & idx) != 0;
    }

    public static int largestCombination(int[] candidates) {
        int ans = 0;

        for(int i=0; i<32; i++) {
            int currSetBits = 0;
            for(int candidate : candidates) {
                if(isSetBit(candidate, 1 << i)) {
                    currSetBits++;
                }
            }
            ans = Math.max(ans, currSetBits);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(largestCombination(new int[]{16,17,71,62,12,24,14}));
    }
}
