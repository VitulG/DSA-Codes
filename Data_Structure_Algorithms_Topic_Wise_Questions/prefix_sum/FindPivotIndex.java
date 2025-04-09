package Data_Structure_Algorithms_Topic_Wise_Questions.prefix_sum;

public class FindPivotIndex {

    public static int pivotIndex(int[] nums) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            int left = 0;
            int right = 0;
            if (i == 0) {
                right = prefixSum[prefixSum.length - 1] - nums[0];
                if (left == right) {
                    return i;
                }
            } else if (i > 0 && i < nums.length - 1) {
                left = prefixSum[i - 1];
                right = prefixSum[nums.length - 1] - prefixSum[i];

                if (left == right) {
                    return i;
                }
            } else if (i == nums.length - 1) {
                left = prefixSum[i-1];

                if (left == right) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1,7,3,6,5,6}));
    }
}
