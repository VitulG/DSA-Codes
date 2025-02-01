public class SpecialArrayI {

    public static boolean isArraySpecial(int[] nums) {
        if(nums.length == 1) {
            return true;
        }

        char prevParity = (nums[0] % 2 == 0) ? 'e' : 'o';

        for(int i=1; i<nums.length; i++) {
            char currParity = (nums[i] % 2 == 0) ? 'e' : 'o';

            if(currParity == prevParity) {
                return false;
            }
            prevParity = currParity;
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(isArraySpecial(new int[]{2,1,4}));
    }
}
