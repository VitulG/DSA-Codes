public class MinimumNumberOfKConsecutiveBitFlips {

    public static int minKBitFilps(int[] nums, int k) {
        int flips = 0;
        int currFlips = 0;

        boolean[] hasFlipped = new boolean[nums.length];

        for(int i=0; i<nums.length; i++) {
            if(i >= k && hasFlipped[i-k]) {
                currFlips--;
            }

            if(currFlips%2 == nums[i]) {
                if(i + k > nums.length) {
                    return -1;
                }

                currFlips++;
                flips++;
                hasFlipped[i] = true;
            }
        }
        return flips;
    }
    
    public static void main(String[] args) {
        System.out.println(minKBitFilps(new int[]{1,1,0}, 2));
    }
}
