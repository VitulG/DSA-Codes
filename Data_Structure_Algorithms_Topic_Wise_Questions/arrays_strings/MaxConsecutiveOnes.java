package Data_Structure_Algorithms_Topic_Wise_Questions.arrays_strings;

public class MaxConsecutiveOnes {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutiveOnes = 0;
        int currentConsecutiveOnes = 0;

        for(int num : nums) {
            if(num == 1) {
                currentConsecutiveOnes++;
            }else {
                maxConsecutiveOnes = Math.max(maxConsecutiveOnes, currentConsecutiveOnes);
                currentConsecutiveOnes = 0;
            }
        }
        return Math.max(maxConsecutiveOnes, currentConsecutiveOnes);
    }

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1}));
    }
}
