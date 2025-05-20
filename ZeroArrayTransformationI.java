import java.util.Arrays;

public class ZeroArrayTransformationI {

    public static boolean isZeroArray(int[] nums, int[][] queries) {
        int[] differenceArray = new int[nums.length];

        for(int[] query : queries) {
            int l = query[0];
            int r = query[1] + 1;

            differenceArray[l] += 1;

            if(r < differenceArray.length) {
                differenceArray[r] -= 1;
            }
        }


        int[] decCount = new int[nums.length];
        decCount[0] = differenceArray[0];

        for(int i=1; i<differenceArray.length; i++) {
            decCount[i] = decCount[i-1] + differenceArray[i];
        }

        for(int i=0; i< nums.length; i++) {
            if(nums[i] > decCount[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isZeroArray(new int[]{4, 3, 2, 1}, new int[][]{
                {1,3},
                {0,2}
        }));
    }
}
