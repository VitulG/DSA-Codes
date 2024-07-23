import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortArrayByIncreasingFrequency {

    static class Numbers {
        int number;
        int frequency;

        public Numbers(int number, int frequency) {
            this.number = number;
            this.frequency = frequency;
        }
    }

    static class SortNumbers implements Comparator<Numbers> {

        @Override
        public int compare(Numbers num1, Numbers num2) {
            if(num1.frequency == num2.frequency) {
                return num2.number - num1.number;
            }else {
                return num1.frequency - num2.frequency;
            }
        }
        
    }

    public static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Numbers> numbers = new ArrayList<Numbers>();

        map.forEach(
            (key, value) -> {
                numbers.add(new Numbers(key, value));
            });

        Collections.sort(numbers, new SortNumbers());

        int[] ans = new int[nums.length];
        int idx = -1;

        for(Numbers number : numbers) {
            int ele = number.number;
            int frequency = number.frequency;

            while(frequency-- > 0) {
                ans[++idx] = ele;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int[] result = frequencySort(new int[]{-1,1,-6,4,5,-6,1,4,1});

        for(int ele : result) {
            System.out.print(ele+" ");
        }
    }
    
}
