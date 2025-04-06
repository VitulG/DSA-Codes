package Data_Structure_Algorithms_Topic_Wise_Questions.sliding_window;

public class MaximumAverageSubarrayI {

    public static double findMaxAverage(int[] nums, int k) {
        double maxAvg;

        int currSum = 0;

        for(int i=0; i<k; i++) {
            currSum += nums[i];
        }

        maxAvg = (double) currSum / k;

        for(int i =k; i<nums.length; i++) {
            currSum += nums[i] - nums[i-k];
            maxAvg = Math.max(maxAvg, (double) currSum / k);
        }
        return maxAvg;
    }

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{-1}, 1));
    }
}
