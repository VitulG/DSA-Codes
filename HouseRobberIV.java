public class HouseRobberIV {

    public static boolean isPossibleToRobHouses(int[] nums, int currentCapability, int k) {
        int robbedHouses = 0;
        int i = 0;

        while(i < nums.length) {
            if(nums[i] <= currentCapability) {
                robbedHouses++;
                i+=2;
            }else {
                i++;
            }
        }
        return robbedHouses >= k;
    }

    public static int minCapacity(int[] nums, int k) {
        int lo = nums[0];
        int hi = nums[0];

        for(int num : nums) {
            lo = Math.min(lo, num);
            hi = Math.max(hi, num);
        }

        int minCapability = 0;

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if(isPossibleToRobHouses(nums, mid, k)) {
                minCapability = mid;
                hi = mid - 1;
            }else {
                lo = mid + 1;
            }
        }
        return minCapability;
    }

    public static void main(String[] args) {
        System.out.println(minCapacity(new int[]{2,3,5,9}, 2));
    }
}
