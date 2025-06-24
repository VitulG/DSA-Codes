import java.util.ArrayList;
import java.util.List;

public class FindAllKDistantIndicesInAnArray {

    public static List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        if(nums.length == 0) {
            return new ArrayList<>();
        }

        boolean[] isDistantIndex = new boolean[nums.length];

        for(int i=0; i<nums.length; i++) {
            if(nums[i] == key) {
                int start = Math.max(0, i - k);
                int end = Math.min(nums.length-1, i + k);

                for(int j = start; j <= end; j++) {
                    isDistantIndex[j] = true;
                }
            }
        }
        List<Integer> distantIndices = new ArrayList<>();

        for(int i=0; i<isDistantIndex.length; i++) {
            if(isDistantIndex[i]) {
                distantIndices.add(i);
            }
        }

        return distantIndices;
    }

    public static void main(String[] args) {
        System.out.println(findKDistantIndices(new int[]{3,4,9,1,3,9,5}, 9, 1));
    }
}
