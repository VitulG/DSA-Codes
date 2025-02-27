import java.util.*;

public class LengthOfLongestFibonacciSubsequence {

    public static int getFibonacciSubsequence(int[] arr, int j, int k, Map<Integer, Integer> map, int[][] dp) {

        if(dp[j][k] != -1) {
            return dp[j][k];
        }

        int number = arr[k] - arr[j];

        if(map.containsKey(number) && map.get(number) < j) {
            int i = map.get(number);

            return dp[j][k] = getFibonacciSubsequence(arr, i, j, map, dp) + 1;
        }
        return dp[j][k] = 2;
    }

    public static int lenLongestFibSubseq(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0; i<arr.length; i++) {
            map.put(arr[i], i);
        }

        int[][] dp = new int[arr.length+1][arr.length+1];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int maxLength = Integer.MIN_VALUE;

        for(int second = 1; second < arr.length; second++) {
            for(int third = second + 1; third < arr.length; third++) {
                int currentLength = getFibonacciSubsequence(arr, second, third, map, dp);

                if(currentLength >= 3) {
                    maxLength = Math.max(maxLength, currentLength);
                }
            }
        }
        return (maxLength == Integer.MIN_VALUE) ? 0 : maxLength;
    }

    public static int lenLongestFibSubseqUsingSet(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for(int num : arr) {
            set.add(num);
        }

        int maxLen = 0;

        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j < arr.length; j++) {
                int first = arr[i];
                int second = arr[j];

                int currLen = 2;

                while(set.contains(first + second)) {
                    second = first + second;
                    first = second - first;
                    currLen++;
                }

                maxLen = Math.max(maxLen, currLen);
            }
        }
        return maxLen == 2 ? 0 : maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lenLongestFibSubseq(new int[]{1,3,7,11,12,14,18}));
    }

}
