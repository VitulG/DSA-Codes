package Data_Structure_Algorithms_Topic_Wise_Questions.binary_search;

public class SearchInAnAlmostSortedArray {

    /*
        Approach 1. Linear search, search whole array and get that target if not return -1
            TC -> O(n) SC -> O(1)

        Approach 2. Using Binary Search, We can check that if the mid-element and their adjacent are equal to the target
                        if yes, we can return that index or else we can discard one portion by mid ± 2.
            TC -> O(log n), SC -> O(1)
     */

    public static int findTarget(int[] arr, int target) {
        if(arr.length == 0) {
            return -1;
        }

        int low = 0;
        int high = arr.length-1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] == target) {
                return mid;
            }

            if(mid - 1 >= low && arr[mid-1] == target) {
                return mid - 1;
            }

            if(mid+1 <= high && arr[mid+1] == target) {
                return mid + 1;
            }

            if(arr[mid] < target) {
                low = mid + 2;
            }else {
                high = mid - 2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findTarget(new int[]{10, 3, 40, 20, 50, 80, 70}, 70));
    }
}
