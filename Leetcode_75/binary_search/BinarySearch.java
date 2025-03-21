package Leetcode_75.binary_search;

public class BinarySearch {

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
