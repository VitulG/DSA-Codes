import java.util.Arrays;

public class StoneGameII {

    public static int stonesForAlice(int[] piles, int idx, int person, int M, int size, int[][][] dp) {
        if(idx >= size) {
            return 0;
        }

        if(dp[person][idx][M] != -1) {
            return dp[person][idx][M];
        }

        int result = (person == 1) ? -1 : Integer.MAX_VALUE;
        int stone = 0;

        for(int x = 1; x <= Math.min(2*M, size-idx); x++) {
            stone += piles[idx+x-1];

            if(person == 1) {
                result = Math.max(result, stone+stonesForAlice(piles, idx+x, 0, Math.max(M, x), size, dp));
            }else{
                result = Math.min(result, stonesForAlice(piles, idx+x, 1, Math.max(x, M), size, dp));
            }
        }
        return dp[person][idx][M] = result;

    }

    public static int gameStoneII(int[] piles) {
        if(piles.length < 2) {
            return 0;
        }

        int[][][] dp = new int[2][101][101];

        for(int[][] twoDp : dp) {
            for(int[] row : twoDp) {
                Arrays.fill(row, -1);
            }
        }

        return stonesForAlice(piles, 0, 1, 1, piles.length, dp);
    }


    public static void main(String[] args) {
        System.out.println(gameStoneII(new int[]{1,2,3,4,5,100}));
    }    
}
