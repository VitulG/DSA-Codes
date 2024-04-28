import java.util.Arrays;

public class FreedomTrail {

    public static int rotateRing(int ringIdx, int charFoundAt, int totalLength) {
        int distance = Math.abs(charFoundAt-ringIdx);
        int wrap = totalLength - distance;
        return Math.min(distance, wrap);
    }



    public static int minSteps(String ring, int ringIdx, String key, int keyIdx, int[][] dp) {
        if(keyIdx >= key.length()) {
            return 0;
        }

        if(dp[ringIdx][keyIdx] != -1) {
            return dp[ringIdx][keyIdx];
        }

        int minSteps = Integer.MAX_VALUE;

        for(int i=0; i<ring.length(); i++) {
            if(ring.charAt(i) == key.charAt(keyIdx)) {
                int totalSteps = rotateRing(ringIdx, i, ring.length()) + 1 + minSteps(ring, i, key, keyIdx+1, dp);
                minSteps = Math.min(minSteps, totalSteps);
            }
        }
        return dp[ringIdx][keyIdx] = minSteps;

    }

    public static int findRotateSteps(String ring, String key) {

        int[][] dp = new int[101][101];
        for(int[] row : dp) {
            Arrays.fill(row,-1);
        }
        return minSteps(ring, 0, key, 0, dp);
    }


    public static void main(String[] args) {
        System.out.println(findRotateSteps("godding", "gd"));
    }
}