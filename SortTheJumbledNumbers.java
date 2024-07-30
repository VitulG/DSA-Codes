import java.util.Arrays;
import java.util.Comparator;

public class SortTheJumbledNumbers {

    static class Pair {
        int number;
        int mappedNumber;

        public Pair(int number, int mappedNumber) {
            this.mappedNumber = mappedNumber;
            this.number = number;
        }
    }

    static class SortNumbers implements Comparator<Pair>{

        @Override
        public int compare(Pair p1, Pair p2) {
            return p1.mappedNumber - p2.mappedNumber;
        }
        
    }

    public static int getMappedNumber(int number, int[] mapping) {
        if(number < 10) {
            return mapping[number];
        }

        int mappedNumber = 0;
        int placedValue = 1;

        while(number != 0) {
            int rem = number%10;
            mappedNumber += placedValue * mapping[rem];
            placedValue *= 10;
            number /= 10;
        }
        return mappedNumber;
    }

    public static int[] sortJumbled(int[] mapping, int[] nums) {

        Pair[] pairs = new Pair[nums.length];
        int idx = -1;

        for(int num : nums) {
            int mappedNumber = getMappedNumber(num, mapping);
            System.out.println(mappedNumber);
            pairs[++idx] = new Pair(num, mappedNumber);
        }

        Arrays.sort(pairs, new SortNumbers());

        idx = 0;

        for(int i = 0; i < pairs.length; i++) {
            nums[idx++] = pairs[i].number;
        }
        return nums;
        
    }

    public static void main(String[] args) {
        int[] sortedNumbers = sortJumbled(new int[]{8,9,4,0,2,1,3,5,7,6}, new int[]{991,338,38});

        for(int ele : sortedNumbers) {
            System.out.print(ele+" ");
        }
    }
}