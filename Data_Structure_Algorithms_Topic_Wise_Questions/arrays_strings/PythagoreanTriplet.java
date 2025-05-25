package Data_Structure_Algorithms_Topic_Wise_Questions.arrays_strings;

import java.util.Arrays;

public class PythagoreanTriplet {

    /*
        Approach 1: Brute Force
            - Use 3 nested loops to check if any triplet satisfies a² + b² = c².
            - Check all combinations of (i, j, k) where i ≠ j ≠ k.

            Time Complexity: O(n³)
            Space Complexity: O(1)

        --------------------------------------------------------

        Approach 2: Sorting + Two Pointers
            1. Square all elements of the array.
            2. Sort the array in ascending order.
            3. Fix one element as the hypotenuse (c²), starting from the end.
            4. Use two pointers to find two values (a² and b²) such that:
               a² + b² == c²
            5. If such a pair is found, return true. Else, move pointers accordingly.

            Time Complexity: O(n² + n log n) ≈ O(n²)  // due to sorting + two pointer traversal
            Space Complexity: O(1)  // In-place operations
     */

    public static boolean pythagoreanTriplet(int[] arr) {
        if(arr.length < 3) {
            return false;
        }

        for(int i=0; i<arr.length-2; i++) {
            for(int j=i+1; j<arr.length-1; j++) {
                for(int k=j+1; k<arr.length; k++) {
                    if((arr[i]*arr[i] + arr[j]*arr[j]) == (arr[k] * arr[k])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean pythagoreanTripletUsingTwoPointer(int[] arr) {
        if(arr.length < 3) {
            return false;
        }

        for(int i = 0; i<arr.length; i++) {
            arr[i] = arr[i] * arr[i];
        }

        Arrays.sort(arr);

        for(int i=arr.length-1; i>=2; i--) {
            int left = 0;
            int right = i-1;

            while(left < right) {
                int sum = arr[right] + arr[left];

                if(sum == arr[i]) {
                    return true;
                }else if(sum < arr[i]) {
                    left++;
                }else {
                    right--;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(pythagoreanTriplet(new int[]{3, 2, 4, 6, 5}));
        System.out.println(pythagoreanTripletUsingTwoPointer(new int[]{3, 2, 4, 6, 5}));
    }
}
