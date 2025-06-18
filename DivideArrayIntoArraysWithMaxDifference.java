import java.util.Arrays;

public class DivideArrayIntoArraysWithMaxDifference {

    public static int[][] divideArray(int[] nums, int k) {
        if(nums.length == 0) {
            return new int[][]{};
        }
        Arrays.sort(nums);

        int len = nums.length;
        int[][] ans = new int[len/3][3];
        int idx = 0;

        for(int i=0; i<len; i+=3) {
            int first = nums[i];
            int second = nums[i+1];
            int third = nums[i+2];

            if(second - first > k || third - first > k || third - second > k) {
                return new int[][]{};
            }

            ans[idx][0] = first;
            ans[idx][1] = second;
            ans[idx][2] = third;

            idx++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] ans = divideArray(new int[]{2,4,2,2,5,2}, 2);

        for(int[] row : ans) {
            System.out.println(Arrays.toString(row));
        }
    }
}
