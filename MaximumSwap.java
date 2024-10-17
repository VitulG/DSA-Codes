public class MaximumSwap {

    public static int maximumSwap(int num) {
        if(num < 10) {
            return num;
        }

        char[] nums = String.valueOf(num).toCharArray();

        int[] preMax = new int[nums.length];
        preMax[preMax.length-1] = nums.length-1;

        for(int i=preMax.length-2; i>=0; i--) {
            int currDigit = nums[i] - '0';
            int prevDigit = nums[preMax[i+1]] - '0';

            preMax[i] = (currDigit > prevDigit) ? i : preMax[i+1];
        }

        for(int i=0; i<nums.length; i++) {
            int rightMaxIdx = preMax[i];
            int digit = nums[rightMaxIdx]-'0';

            if(nums[i]-'0' < digit) {
                char ch = nums[i];
                nums[i] = nums[rightMaxIdx];
                nums[rightMaxIdx] = ch;
                break;
            }
        }
        return Integer.parseInt(new String(nums));
    }

    public static void main(String[] args) {
        System.out.println(maximumSwap(9973));
    }
}
