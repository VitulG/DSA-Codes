public class SortColors {

    public static void sortColors(int[] nums) {
        int[] freq = new int[3];

        for(int num : nums) {
            freq[num]+=1;
        }

        int idx = 0;

        for(int i=0; i<freq.length; i++) {
            int currFreq = freq[i];
            while(currFreq-- > 0) {
                nums[idx++] = i;
            }
        }

    }

    public static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

    public static void sortColorsUsingDutchNationalFlagAlgo(int[] nums) {
        if(nums.length <= 1) {
            return;
        }

        int zeroPointer = 0;
        int onePointer = 0;
        int twoPointer = nums.length-1;

        while(onePointer <= twoPointer) {
            if(nums[onePointer] == 0) {
                swap(nums, zeroPointer, onePointer);
                zeroPointer++;
                onePointer++;
            } else if (nums[onePointer] == 1) {
                onePointer++;
            }else {
                swap(nums, onePointer, twoPointer);
                onePointer++;
                twoPointer--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};

        sortColors(nums);

        for(int i : nums) {
            System.out.print(i+" ");
        }

        
    }
    
}
