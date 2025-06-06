package Data_Structure_Algorithms_Topic_Wise_Questions.binary_search;

public class KthMissingPositiveNumberInASortedArray {

    /*
        Approach 1. Brute force starts a loop from 1 to infinity to find kth missing positive integer.
                      check a number in the array if it is not present that means it's a missing number
                      decrement the count of k if k == 0 we will break the outer loop and return the kth
                      missing element.

                      TC -> O(k * n)
                      SC -> O(1)

        Approach 2. Using Hashing, we can reduce searching time in the array by using set, insert all the elements
                      in the set and check the same if the element is not present decrement the count if k == 0 break
                      the outer loop and return the kth missing element.

                      TC -> O(k)
                      SC -> O(n)

        Approach 3. Using Binary Search, we know elements are in sorted form so we can use Binary search.
                      we are sure that on the ith position i+1 th element must be present if not that means
                      element is missing.
                      2. we can check, on the mid index how many elements are missing if
                      missing element < k that means kth element will not lying there then increment the search
                      space in the right side
                      3. else decrease the search space on the left side.
                      4. In the end, return low + kth element which will be the missing number.

                      TC -> O(log n)
                      SC -> O(1)
     */

    public static int kthMissing(int[] arr, int k) {
        int low = 0;
        int high = arr.length-1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] - (mid + 1) < k) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return low + k;
    }

    public static void main(String[] args) {
        System.out.println(kthMissing(new int[]{3,5,9,10,11,12}, 5));
    }
}
