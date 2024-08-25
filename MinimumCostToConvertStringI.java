import java.util.Arrays;

public class MinimumCostToConvertStringI {


    public static long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        if(source == null || source.isEmpty() || original.length == 0 || cost.length == 0 || changed.length == 0) {
            return 0L;
        }

        int[][] adjMatrix = new int[26][26];

        for(int[] row : adjMatrix) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        int len = original.length;

        for(int i=0; i<len; i++) {
            adjMatrix[original[i]-'a'][changed[i]-'a'] = Math.min(adjMatrix[original[i]-'a'][changed[i]-'a'], cost[i]);
        }

        for(int i=0; i<26; i++) {
            adjMatrix[i][i] = 0;
        }

        // applying floyd warshell algorithm

        for(int inter = 0; inter < 26; inter++) {
            for(int src = 0; src < 26; src++) {
                for(int dst = 0; dst < 26; dst++) {
                    if(adjMatrix[src][inter] != Integer.MAX_VALUE 
                                && adjMatrix[inter][dst] != Integer.MAX_VALUE) {
                        adjMatrix[src][dst] = Math.min(adjMatrix[src][inter] + adjMatrix[inter][dst], adjMatrix[src][dst]);
                    }
                }
            }
        }

        int i = 0;
        long ans = 0L;

        while(i < source.length()) {
            if(source.charAt(i) != target.charAt(i)) {
                if(adjMatrix[source.charAt(i)-'a'][target.charAt(i)-'a'] == Integer.MAX_VALUE) {
                    return -1L;
                }
                ans += adjMatrix[source.charAt(i)-'a'][target.charAt(i)-'a']; 
            }
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minimumCost("abcd", "abce", new char[]{'a'}, 
                        new char[]{'e'}, new int[]{1000}));

    }
    
}
