package Data_Structure_Algorithms_Topic_Wise_Questions.binary_search;

public class BinarySearch {

    /*
        Approach 1. Linear Search, iterate in the array and check if the element present or not. If yes,
                        return that element index else return -1.
                    TC -> O(n)
                    SC -> O(1)

        Approach 2. Binary Search, we know Array is sorted so we can use Binary search over here. first we need
                        to find the middle element if the element is lesser than the mid-element, then we can skip
                        right side of the middle element or else we can skip the left part.

                    TC -> O(log n)
                    SC -> O(1)
     */

    public static int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if(nums[mid] == target) {
                return mid;
            }else if(nums[mid] < target) {
                lo = mid + 1;
            }else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
