public class MinimumRecolorsToGetKConsecutiveBlackBlocks {

    public static int minimumRecolors(String blocks, int k) {
        int whiteBalls = 0;

        int minRecolorBalls = Integer.MAX_VALUE;

        for(int i=0; i<k; i++) {
            if(blocks.charAt(i) == 'W') {
                whiteBalls++;
            }
        }

        minRecolorBalls = Math.min(minRecolorBalls, whiteBalls);

        for(int i = k; i<blocks.length(); i++) {
            char prev = blocks.charAt(i-k);
            char next = blocks.charAt(i);

            if(prev == 'W') {
                whiteBalls--;
            }

            if(next == 'W') {
                whiteBalls++;
            }

            minRecolorBalls = Math.min(minRecolorBalls, whiteBalls);

        }
        return minRecolorBalls;

    }

    public static void main(String[] args) {
        System.out.println(minimumRecolors("WBWBBBW", 2));
    }
}
