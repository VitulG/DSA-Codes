public class PatchingArray {

    // observation based question
    
    public static int minPatches(int[] nums, int n) {
        int start = 0;
        long maxTill = 0;
        int patches = 0;

        while(maxTill < n ) {
            if(start < nums.length && nums[start] <= maxTill+1) {
                maxTill += nums[start];
                start++;
            }else {
                maxTill += (maxTill+1);
                patches++;
            }
        }
        return patches;
    }


    public static void main(String[] args) {
        System.out.println(minPatches(new int[]{1,3}, 6));
    }
}
