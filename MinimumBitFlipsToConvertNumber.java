public class MinimumBitFlipsToConvertNumber {

    public static int minBitFlips(int start, int goal) {
        int answer = start ^ goal;
        int temp = answer;
        int minBitFlips = 0;
        int loopTill = 0;

        while(temp != 0) {
            loopTill+=1;
            temp /= 2;
        }

        for(int i=0; i<loopTill; i++) {
            if((answer&(1<<i)) != 0) {
                minBitFlips++;
            }
        }
        return minBitFlips;
    }

    public static void main(String[] args) {
        System.out.println(minBitFlips(3,4));
    }
}
