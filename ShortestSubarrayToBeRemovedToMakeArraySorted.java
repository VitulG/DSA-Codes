import java.util.Stack;

public class ShortestSubarrayToBeRemovedToMakeArraySorted {

    public static int findLengthOfShortestSubarray(int[] arr) {
        // step 1. to find the minimum element from the right side kyuki uske baad element sort hi honge
        int len = arr.length;

        int ri = len-1;

        while(ri > 0 && arr[ri] >= arr[ri-1]) {
            ri--;
        }

        if(ri == 0) {
            return 0;
        }

        // step 2. ki hum check karenge ith element with jth element agar element same hai yaa ith element small hai to that means ki array is sorted
        int le = 0;
        int minimumRemoval = ri;

        while(le < len && (le == 0 || arr[le-1] <= arr[le])) {
            while(ri < len && arr[le] > arr[ri]) {
                ri++;
            }
            minimumRemoval = Math.min(minimumRemoval, ri - le - 1);
            le++;
        }
        return  minimumRemoval;
    }

    public static void main(String[] args) {
        System.out.println(findLengthOfShortestSubarray(new int[]{1,2,3}));
    }
}
