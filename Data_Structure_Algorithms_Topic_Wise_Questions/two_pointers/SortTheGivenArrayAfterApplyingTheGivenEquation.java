package Data_Structure_Algorithms_Topic_Wise_Questions.two_pointers;

import java.util.ArrayList;
import java.util.Collections;

public class SortTheGivenArrayAfterApplyingTheGivenEquation {

    /*
        Approach 1. a. first convert the array into the given equation.
                    b. after converting, we just need to sort the array.
                    c. using any sorting algo to sort the array.

            TC -> O(n log n)
            SC -> O(1)

        Approach 2. Using Two pointers, the factor lies in what value of A is if it's -ve then we will get
                        a min value either from the left side of the array or right side else if the A is +ve
                        then we will get a max value from either side and we can check accordingly.

            TC -> O(n) // since array is sorted we can use two pointer
            SC -> O(n)
     */

    public static ArrayList<Integer> sortArray(int[] arr, int A, int B, int C) {
        ArrayList<Integer> ans = new ArrayList<>();

        for(int num : arr) {
            ans.add(num*num*A + B*num + C);
        }

        Collections.sort(ans);
        return ans;
    }

    public static int calculateEquation(int X, int A, int B, int C) {
        return A*X*X + B*X + C;
    }

    public static ArrayList<Integer> sortArrayUsingTwoPointer(int[] arr, int A, int B, int C) {
        int size = arr.length;

        int[] sortedArray = new int[size];
        int idx = (A <= 0) ? 0 : size-1;

        int left = 0;
        int right = sortedArray.length-1;

        while(left <= right) {
            int equationValueFromLeft = calculateEquation(arr[left], A, B, C);
            int equationValueFromRight = calculateEquation(arr[right], A, B, C);

            if(A <= 0) {
                if(equationValueFromLeft <= equationValueFromRight) {
                    sortedArray[idx++] = equationValueFromLeft;
                    left++;
                }else {
                    sortedArray[idx++] = equationValueFromRight;
                    right--;
                }
            }else {
                if(equationValueFromLeft > equationValueFromRight) {
                    sortedArray[idx--] = equationValueFromLeft;
                    left++;
                }else {
                    sortedArray[idx--] = equationValueFromRight;
                    right--;
                }
            }

        }
        ArrayList<Integer> ans = new ArrayList<>();

        for(int num : sortedArray) {
            ans.add(num);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(sortArrayUsingTwoPointer(new int[]{-3, -1, 2, 4}, -1,0,2));
        System.out.println(sortArray(new int[]{-3, -1, 2, 4}, 1,2,3));
    }
}
