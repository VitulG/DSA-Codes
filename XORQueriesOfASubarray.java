import java.util.Arrays;

public class XORQueriesOfASubarray {

    public static int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefixXor = new int[arr.length];
        prefixXor[0] = arr[0];

        for(int i=1; i<arr.length; i++) {
            prefixXor[i] = prefixXor[i-1] ^ arr[i];
        }

        int[] ans = new int[queries.length];
        int idx = -1;

        for(int[] query : queries) {
            int lo = query[0];
            int hi = query[1];

            if(lo == 0) {
                ans[++idx] = prefixXor[hi];
            } else {
                ans[++idx] = prefixXor[lo-1] ^ prefixXor[hi];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ans = xorQueries(new int[]{1,3,4,8}, new int[][]{{0,1},{1,2},{0,3},{3,3}});

        for(int ele : ans) {
            System.out.print(ele+" ");
        }
    }
}
