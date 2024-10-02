import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RankTransformOfAnArray {
    public static int[] arrayRankTransform(int[] arr) {
        int[] newArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(newArr);

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;

        for(int ele : newArr) {
            if(!map.containsKey(ele)) {
                map.put(ele, rank++);
            }
        }

        int[] ranks = new int[arr.length];

        for(int i=0; i<arr.length; i++) {
            ranks[i] = map.get(arr[i]);
        }
        return ranks;
    }


    public static void main(String[] args) {
        int[] arr = {37,12,28,9,100,56,80,5,12};
        int[] result = arrayRankTransform(arr);

        for(int ele : result) {
            System.out.print(ele+" ");
        }
    }
}
