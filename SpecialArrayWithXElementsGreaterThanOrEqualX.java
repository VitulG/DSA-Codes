import java.util.Arrays;

public class SpecialArrayWithXElementsGreaterThanOrEqualX {

    public static int countX(int[] nums, int X) {

        int count = 0;
        for(int ele : nums) {
            if(ele >= X) {
                count++;
            }
        }
        return count;
 
    }

    public static int specialArray(int[] nums) {
        Arrays.sort(nums);

        int lo = 0;
        int hi = nums.length;

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            
            int countGreaterThanX = countX(nums, mid);

            if(countGreaterThanX == mid) {
                return mid;
            }else if(countGreaterThanX > mid) {
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(specialArray(new int[]{3,5}));
    }
    
}
