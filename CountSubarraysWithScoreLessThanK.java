public class CountSubarraysWithScoreLessThanK {

    public static long countSubarrays(int[] nums, long k) {
        int left = 0;
        int right = 0;

        long subarrays = 0L;
        long sum = 0;

        while(right < nums.length) {
            sum += nums[right];

            while(left <= right && sum * (right - left + 1) >= k) {
                sum -= nums[left];
                left++;
            }
            subarrays += (right - left + 1);
            right++;
        }
        return subarrays;
    }

    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{2,1,4,3,5}, 10));
    }
}
