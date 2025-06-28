package Data_Structure_Algorithms_Topic_Wise_Questions.binary_search;

import java.util.ArrayList;
import java.util.Arrays;

public class CountingElementsInTwoArrays {

    /*
        Approach 1. Brute force pick a element from a and get the count how many elements are less than or equal to that num
                      in b array.
                    TC -> O(n * m)
                    SC -> O(1)

        Approach 2. Binary Search, the idea is to sort b array to perform binary Search efficiently. Iterate in the array a
                        and check how many elements are <= num in sorted array b using binary Search.
                    TC -> O(m log m + n log m) => O(m log m)
                    SC -> O(1)
     */

    public static int getNumbersLessThanOrEqualToNum(int num, int[] b) {
        int low = 0;
        int high = b.length-1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(b[mid] <= num) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static ArrayList<Integer> countLessEq(int[] a, int[] b) {
        Arrays.sort(b);
        ArrayList<Integer> ans = new ArrayList<>();

        for(int num : a) {
            int count = getNumbersLessThanOrEqualToNum(num, b);
            ans.add(count);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countLessEq(new int[]{4, 8, 7, 5, 1}, new int[]{4, 48, 3, 0, 1, 1, 5}));
    }
}
