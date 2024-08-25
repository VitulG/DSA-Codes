import java.util.Arrays;

public class FindKthSmallestPairDistance {

    public static int isPossibleToIncreaseDistance(int[] nums, int distance) {
        int count = 0;
        int i = 0;
        int j = 1;

        while(j < nums.length) {
            while(nums[j] - nums[i] > distance) {
                i++;
            }
            count += (j-i);
            j++;
        }
        return count;
    }

    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums[nums.length-1] - nums[0];

        int kthDistance = 0;

        while(left <= right) {
            int distance = left + (right - left) / 2;

            int currPairs = isPossibleToIncreaseDistance(nums, distance);

            if(currPairs >= k) {
                kthDistance = distance;
                right = distance-1;
            }else{
                left = distance+1;
            }
        }
        return kthDistance;
    }

    public static void main(String[] args) {
        System.out.println(smallestDistancePair(new int[]{1,6,1}, 3));
    }
}