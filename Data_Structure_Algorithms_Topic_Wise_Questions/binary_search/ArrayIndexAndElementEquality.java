package Data_Structure_Algorithms_Topic_Wise_Questions.binary_search;

public class ArrayIndexAndElementEquality {

    // Brute force solution Time Complexity -> O(n)
    // Space Complexity -> O(1)

    public static int indexEqualsValueSearch(int[] arr) {
        int low = 0;
        int high = arr.length-1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] == mid) {
                return mid;
            }else if(arr[mid] < mid) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // Binary Search solution Time Complexity -> O(log n)
    // Space Complexity -> O(1)

    public static void main(String[] args) {
        System.out.println(indexEqualsValueSearch(new int[]{-8,0,2,5}));
    }
}
