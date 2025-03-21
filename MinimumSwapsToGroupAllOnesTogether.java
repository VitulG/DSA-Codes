public class MinimumSwapsToGroupAllOnesTogether {

    public static int minSwaps(int[] arr) {
        int oneCount = 0;

        for(int num : arr) {
            if(num == 1) {
                oneCount++;
            }
        }

        int minSwaps = Integer.MAX_VALUE;
        int currZeroCount = 0;

        for(int i=0; i<oneCount; i++) {
            if(arr[i] == 0) {
                currZeroCount++;
            }
        }

        minSwaps = currZeroCount;

        for(int i = oneCount; i<arr.length; i++) {
            int next = arr[i];
            int prev = arr[i - oneCount];

            if(prev == 0) {
                currZeroCount--;
            }

            if(next == 0) {
                currZeroCount++;
            }
            minSwaps = Math.min(minSwaps, currZeroCount);
        }
        return minSwaps;
    }

    public static void main(String[] args) {
        System.out.println(minSwaps(new int[]{1,0,1,0,1,0,0,1,1,0,1}));
    }
}
