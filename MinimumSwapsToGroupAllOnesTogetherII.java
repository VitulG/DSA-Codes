public class MinimumSwapsToGroupAllOnesTogetherII {

    public static int minSwaps(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int totalNumberOfOnes = 0;

        for(int num : nums) {
            if(num == 1) {
                totalNumberOfOnes++;
            }
        }

        int currWindowOnes = 0;

        for(int i=0; i<totalNumberOfOnes; i++) {
            if(nums[i] == 1) {
                currWindowOnes++;
            }
        }

        int maxWindowOnes = currWindowOnes;

        for(int i=totalNumberOfOnes; i< nums.length + totalNumberOfOnes; i++) {
            if(nums[i%nums.length] == 1) {
                currWindowOnes++;
            }

            if(nums[(i-totalNumberOfOnes)%nums.length] == 1) {
                currWindowOnes--;
            }

            maxWindowOnes = Math.max(maxWindowOnes, currWindowOnes);
        }

        return totalNumberOfOnes - maxWindowOnes;
    }

    public static void main(String[] args) {
        System.out.println(minSwaps(new int[]{1,1,0,0,1}));
    }
    
}
