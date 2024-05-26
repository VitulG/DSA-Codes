import java.util.Arrays;

public class StudentAttendanceRecordII {

    public static int getAttendanceRecord(int num, int abs, int lt, int mod, int[][][] dp) {
        if (abs > 1 || lt >= 3) {
            return 0;
        }

        if (num == 0) {
            return 1;
        }

        if (dp[num][abs][lt] != -1) {
            return dp[num][abs][lt];
        }

        int present = getAttendanceRecord(num - 1, abs, 0, mod, dp) % mod;
        int absent = getAttendanceRecord(num - 1, abs + 1, 0, mod, dp) % mod;
        int late = getAttendanceRecord(num - 1, abs, lt + 1, mod, dp) % mod;

        dp[num][abs][lt] = ((present + absent)%mod + late) % mod;
        return dp[num][abs][lt];
    }

    public static int checkRecord(int n) {
        int mod = 1000000007;
        int[][][] dp = new int[n+1][2][3];

        for(int[][] rows : dp) {
            for(int[] row : rows) {
                Arrays.fill(row, -1);
            }
        }
        return getAttendanceRecord(n, 0, 0, mod, dp);
    }

    public static void main(String[] args) {
        System.out.println(checkRecord(10000));
    }
    
}
