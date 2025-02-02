public class CheckIfArrayIsSortedAndRotated {

    public static boolean check(int[] nums) {
        if(nums.length == 1) {
            return true;
        }

        int dip = 0;

        for(int i=1; i< nums.length; i++) {
            if(nums[i] < nums[i-1]) {
                dip++;
            }
        }

        if(dip == 0) {
            return true;
        }

        return (dip == 1 && nums[0] >= nums[nums.length - 1]);
    }

    public static void main(String[] args) {
        System.out.println(check(new int[]{2,1,3,4}));
    }
}
