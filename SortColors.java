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

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};

        sortColors(nums);

        for(int i : nums) {
            System.out.print(i+" ");
        }

        
    }
    
}
