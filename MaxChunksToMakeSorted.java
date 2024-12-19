public class MaxChunksToMakeSorted {

    public static int maxChunksToSorted(int[] arr) {
        int validTill = 0;
        int chunks = 0;

        for(int i=0; i<arr.length; i++) {
            validTill = Math.max(validTill, arr[i]);
            if(validTill == i) {
                chunks++;
            }
        }
        return chunks;
    }

    // we are using chaining technique here we will find out the max element we will find that index
    // the scope of the max variable will be there so we can partition as 1.
    // Time Complexity => O(N)
    // Space "      "  => O(1)

    public static void main(String[] args) {
        System.out.println(maxChunksToSorted(new int[]{1,0,2,3,4}));
    }
}
