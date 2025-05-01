package Data_Structure_Algorithms_Topic_Wise_Questions.arrays_strings;

public class MaxConsecutiveOnesII {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutiveOnes = 0;

        boolean isContainOnes = true;

        for(int num : nums) {
            if(num == 0) {
                isContainOnes = false;
                break;
            }
        }

        if(isContainOnes) {
            return nums.length;
        }

        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                int leftOnes = 0;
                int left = i-1;

                while(left >= 0 && nums[left] == 1) {
                    leftOnes++;
                    left--;
                }

                int rightOnes = 0;
                int right = i+1;

                while(right < nums.length && nums[right] == 1) {
                    rightOnes++;
                    right++;
                }
                maxConsecutiveOnes = Math.max(maxConsecutiveOnes, leftOnes + rightOnes + 1);
            }
        }
        return maxConsecutiveOnes;
    }

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,1,0,1}));
    }
}
