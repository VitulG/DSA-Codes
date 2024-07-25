import java.util.Arrays;
import java.util.Comparator;

public class SortAnArray {

    static class SortNums implements Comparator<Integer> {

        @Override
        public int compare(Integer num1, Integer num2) {
            return num1 - num2;
        }

    }

    public static int[] sortArray(int[] nums) {
        if(nums.length == 1) {
            return nums;
        }

        Integer[] sorted = new Integer[nums.length];
        int idx = 0;

        for(int num : nums) {
            sorted[idx++] = num;
        }

        Arrays.sort(sorted, new SortNums());

        idx = -1;

        for(Integer num : sorted) {
            nums[++idx] = num;
        }

        return nums;

    }


    public static void main(String[] args) {
        int[] sorted = sortArray(new int[]{5,1,1,2,0,0});

        for(int num : sorted) {
            System.out.print(num+" ");
        }
    }
    
}
