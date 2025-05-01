package Data_Structure_Algorithms_Topic_Wise_Questions.binary_search;

public class BitonicPoint {

    public static int findMaximum(int[] arr) {
        // Approach 1. using linear search just needs to find the dipping point
        // TC -> O(n) , SC -> O(1)

        // Approach 2. we can use Binary search over here since the array is strictly sorted
        // TC -> O(n log n), SC -> O(1)

        int low = 0;
        int high = arr.length-1;

        int ans = -1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(mid+1 < arr.length && arr[mid] < arr[mid+1]) {
                low = mid + 1;
            } else {
                ans = arr[mid];
                high = mid - 1;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findMaximum(new int[]{120, 100, 80, 20, 0}));
    }
}
