package Data_Structure_Algorithms_Topic_Wise_Questions.bit_manipulation;

public class SingleNumberI {

    public static int findUnique(int[] arr) {
        // Approach 1. using brute force, we can check every number if it comes again
        // TC -> O(n^2) SC -> O(1)

        // Approach 2. using set data structure, we can check if the element is present in the set or not
        // TC -> O(n) SC -> O(n)

        // Approach 3. using xor, We know the property of xor is a^a = 0 and a^0 = a, we can use these properties
        // TC -> O(n) SC -> O(1)

        int unique = 0;

        for(int num : arr) {
            unique ^= num;
        }
        return unique;
    }

    public static void main(String[] args) {
        System.out.println(findUnique(new int[]{1,2,3,2,1}));
    }
}
