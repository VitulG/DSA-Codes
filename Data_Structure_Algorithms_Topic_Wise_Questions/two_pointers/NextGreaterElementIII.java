package Data_Structure_Algorithms_Topic_Wise_Questions.two_pointers;

public class NextGreaterElementIII {

    public static void swapArray(char[] nums, int st, int en) {
        while(st < en) {
            char temp = nums[st];
            nums[st] = nums[en];
            nums[en] = temp;
            st++;
            en--;
        }
    }

    public static int nextGreaterElement(int num) {
        char[] nums = String.valueOf(num).toCharArray();

        int dip = -1;

        for(int i = nums.length-2; i>=0; i--) {
            if(nums[i] < nums[i+1]) {
                dip = i;
                break;
            }
        }

        // last number which has the same digit and numbers
        if(dip == -1) {
            return -1;
        }else {
            // find the next greater element from nums[dip] from the right
            int j = nums.length-1;

            while(j > dip) {
                if(nums[j] > nums[dip]) {
                    char temp = nums[j];
                    nums[j] = nums[dip];
                    nums[dip] = temp;
                    break;
                }
                j--;
            }
            swapArray(nums, dip+1, nums.length-1);
        }

        long nextGreaterNumber = 0L;

        for (char ch : nums) {
            int currentDigit = ch - '0';
            nextGreaterNumber = nextGreaterNumber * 10 + currentDigit;
        }
        return nextGreaterNumber > Integer.MAX_VALUE ? -1 : (int) nextGreaterNumber;
    }

    public static void main(String[] args) {
        System.out.println(nextGreaterElement(123));
    }
}
