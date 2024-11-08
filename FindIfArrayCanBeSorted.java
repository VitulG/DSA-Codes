public class FindIfArrayCanBeSorted {

    public static int getSetBits(int element) {
        int setBits = 0;

        for(int i=0; i<32; i++) {
            if((element&(1<<i)) != 0) {
                setBits++;
            }
        }
        return setBits;
    }

    private static void swap(int[] nums, int idx, int adjIdx) {
        int temp = nums[idx];
        nums[idx] = nums[adjIdx];
        nums[adjIdx] = temp;
    }

    public static boolean canSortArray(int[] nums) {
        if(nums.length == 1) {
            return true;
        }

        boolean sorted;
        do {
            sorted = true;
            for (int i = 0; i < nums.length - 1; i++) {
                int currSetBits = getSetBits(nums[i]);
                int adjSetBits = getSetBits(nums[i + 1]);

                if (currSetBits == adjSetBits && nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                    sorted = false; // Set to false if a swap was made
                }
            }
        } while (!sorted);

        for(int i=0; i<nums.length-1; i++) {
            if(nums[i] > nums[i+1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canSortArray(new int[]{8,4,2,30,15}));
    }
}
