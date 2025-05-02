package Data_Structure_Algorithms_Topic_Wise_Questions.backtracking;

public class BlackAndWhite {

    public static long numOfWays(int N, int M) {
        long ways = 0L;
        int MOD = 1000000007;

        int[] dx = {-2, -2, 2, 2, -1, -1, 1, 1};
        int[] dy = {1, -1, -1, 1, -2, 2, -2, 2};

        int directions = dx.length;

        for(int row = 0; row < N; row++) {
            for(int col = 0; col < M; col++) {
                int totalPositions = N * M;
                int remainingPositions = totalPositions - 1;
                int attackingPositions = 0;

                for(int direction = 0; direction < directions; direction++) {
                    int newRow = row + dx[direction];
                    int newCol = col + dy[direction];

                    if(newRow >= 0 && newRow < N && newCol >= 0 && newCol < M) {
                        attackingPositions++;
                    }
                }

                long validPositions = remainingPositions - attackingPositions;
                ways = (ways + validPositions)%MOD;

            }
        }
        return ways;

    }

    public static void main(String[] args) {
        System.out.println(numOfWays(2,3));
    }
}
