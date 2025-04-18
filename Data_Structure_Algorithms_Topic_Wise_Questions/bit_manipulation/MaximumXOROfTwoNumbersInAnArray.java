package Data_Structure_Algorithms_Topic_Wise_Questions.bit_manipulation;

public class MaximumXOROfTwoNumbersInAnArray {

    public static int maxXor(int[] arr) {
        // Approach 1. Using Brute force O(n^2)
        // Optimal approach can be using trie which I will add in trie folder
        int maxXor = 0;

        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                maxXor = Math.max(maxXor, arr[i]^arr[j]);
            }
        }
        return maxXor;



    }

    public static void main(String[] args) {
        System.out.println(maxXor(new int[]{25, 10, 2, 8, 5, 3}));
    }
}
