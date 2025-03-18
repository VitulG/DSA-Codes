public class LongestNiceSubarray {

    public static int longestNiceSubarray(int[] nums) {
        int le = 0;
        int ri = 0;

        int longestSubarray = Integer.MIN_VALUE;
        int bitMask = 0;

        while(ri < nums.length) {
            while ((bitMask & nums[ri]) != 0) {
                bitMask ^= nums[le]; // Remove nums[le] from the window
                le++; // Move left pointer
            }

            // Add nums[ri] to the window
            bitMask |= nums[ri];

            // Update maximum length
            longestSubarray = Math.max(longestSubarray, ri - le + 1);

            ri++; // Expand window
        }
        return longestSubarray;
    }

    public static void main(String[] args) {
        System.out.println(longestNiceSubarray(new int[]{1,3,8,48,10}));
    }
}
