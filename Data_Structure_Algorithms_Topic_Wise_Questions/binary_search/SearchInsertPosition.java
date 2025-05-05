package Data_Structure_Algorithms_Topic_Wise_Questions.binary_search;

public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;

        int insertPosition = -1;

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if(nums[mid] == target) {
                return mid;
            }else if(nums[mid] < target) {
                lo = mid+1;
            }else {
                insertPosition = mid;
                hi = mid-1;
            }
        }
        return insertPosition == -1 ? nums.length : insertPosition;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6}, 2));
    }
}
