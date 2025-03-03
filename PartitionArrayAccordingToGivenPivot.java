import java.util.Arrays;

public class PartitionArrayAccordingToGivenPivot {

    public static int[] pivotArray(int[] nums, int pivot) {
        int[] rearrangedArray = new int[nums.length];
        int idx = -1;

        for(int num : nums) {
            if(num < pivot) {
                rearrangedArray[++idx] = num;
            }
        }

        for(int num : nums) {
            if(num == pivot) {
                rearrangedArray[++idx] = num;
            }
        }

        for(int num : nums) {
            if(num > pivot) {
                rearrangedArray[++idx] = num;
            }
        }

        return rearrangedArray;
    }

    public static void main(String[] args) {
        int[] arr = pivotArray(new int[]{9,12,5,10,14,3,10}, 10);

        Arrays.stream(arr)
                .forEach(System.out::println);

    }
}
