package Data_Structure_Algorithms_Topic_Wise_Questions.binary_search;

public class MissingElementOfAP {

    /*
        Asked in -> Adobe, Samsung, DE Shaw(Media.net) hardest to crack

        Approach 1. Using hashing store all the elements in the hashset and then check with common difference
                        if the next number is present or not if yes return that number else returns the next
                            array length number.
                    TC -> O(2N), SC -> O(N)

        Approach 2. Using Maths just iterate the loop and check if the left difference is equal to the right difference
                        if not we have the answer where the difference is low else return the next array length number.

                    TC -> O(N), SC -> O(1)

        Approach 3. Using Binary Search, we will take two pointers left and right and then check if the difference is equal or not
                         if the difference is not equal, then we have the answer with left or right difference whichever is minimum.
                        or else we have to discard one part, we will take left part if the mid th term is equal to arr[mid] we can discard
                        the left half and move to right or else move to left discard right.
                    TC -> O(log N), SC -> O(1)
     */

    public static int findMissing(int[] arr) {
        int len = arr.length;

        int low = 1;
        int high = len-2;
        int difference = arr[1] - arr[0];

        while(low <= high) {
            int mid = low + (high - low) / 2;

            int leftDifference = arr[mid] - arr[mid-1];
            int rightDifference = arr[mid+1] - arr[mid];

            if(leftDifference != rightDifference) {
                return (leftDifference > rightDifference) ? arr[mid] - rightDifference
                        : arr[mid] + leftDifference;
            }

            // find the mid th term of this AP
            int n = mid - low + 1;
            int a = arr[low];

            int midThTerm = a + (n - 1) * difference;

            if(midThTerm == arr[mid]) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return arr[0] + (len*(arr[1]-arr[0]));
    }

    public static void main(String[] args) {
        System.out.println(findMissing(new int[]{4, 7, 10, 13, 16}));
    }
}
