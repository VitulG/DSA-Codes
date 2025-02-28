import java.util.Arrays;

public class ShortestCommonSupersequence {

    public static String shortestCommonSupersequence(String str1, String str2) {
        int[][] dp = new int[str1.length()+1][str2.length()+1];

        for(int row=0; row <= str1.length(); row++) {
            dp[row][0] = 0;
        }

        for(int col = 0; col <= str2.length(); col++) {
            dp[0][col] = 0;
        }

        for(int row = 1; row <= str1.length(); row++) {
            for(int col = 1; col <= str2.length(); col++) {
                if(str1.charAt(row-1) == str2.charAt(col-1)) {
                    dp[row][col] =  1 + dp[row-1][col-1];
                }else {
                    dp[row][col] = Math.max(dp[row][col-1], dp[row-1][col]);
                }
            }
        }

        StringBuilder ans = new StringBuilder();

        int row = dp.length-1;
        int col = dp[0].length-1;

        while(row > 0 && col > 0) {
            if(str1.charAt(row-1) == str2.charAt(col-1)) {
                ans.append(str1.charAt(row-1));
                row--;
                col--;
            }else if(dp[row-1][col] > dp[row][col-1]) {
                ans.append(str1.charAt(row-1));
                row--;
            }else {
                ans.append(str2.charAt(col-1));
                col--;
            }
        }

        while(row > 0) {
            ans.append(str1.charAt(row-1));
            row--;
        }

        while(col > 0) {
            ans.append(str2.charAt(col-1));
            col--;
        }

        return ans.reverse().toString();

    }

    public static void main(String[] args) {
        System.out.println(shortestCommonSupersequence("abac", "cab"));
    }
}
