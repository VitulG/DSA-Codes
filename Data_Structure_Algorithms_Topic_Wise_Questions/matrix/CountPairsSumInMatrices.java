package Data_Structure_Algorithms_Topic_Wise_Questions.matrix;

import java.util.HashSet;
import java.util.Set;

public class CountPairsSumInMatrices {

    /*
        Approach 1. Brute force solution, check every pair by choosing every element in matrix 1 with every number in
                        matrix 2.
                    TC -> O(n^4)
                    SC -> O(1)

        Approach 2. Using Hashing, insert all the elements of matrix 1 in a set and check if
                        my set contains an x - matrix2 element if yes we found a pair and increment the count.
                    TC -> O(n^2)
                    SC -> O(n^2)
     */

    public static int countPairs(int[][] mat1, int[][] mat2, int x) {
        // code here
        Set<Integer> set = new HashSet<>();

        for(int[] row : mat1) {
            for(int num : row) {
                set.add(num);
            }
        }

        int pairs = 0;

        for(int[] row : mat2) {
            for(int num : row) {
                if(set.contains(x - num)) {
                    pairs++;
                }
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        System.out.println(countPairs(new int[][]{
                {1,5,6},
                {8,10,11},
                {15,16,18}
        }, new int[][]{
                {2,4,7},
                {9,10,12},
                {13,16,20}
        }, 21));
    }
}
