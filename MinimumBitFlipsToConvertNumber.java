public class MinimumBitFlipsToConvertNumber {

    public static int minBitFlips(int start, int goal) {
        int minBitFlips = 0;

        for(int i=0; i<32; i++) {
            int bitStart = (start >> i) & 1;
            int bitGoal = (goal >> i) & 1;

            if(bitStart!=bitGoal) {
                minBitFlips++;
            }
        }
        return minBitFlips;
    }

    public static void main(String[] args) {
        System.out.println(minBitFlips(3,4));
    }
}
