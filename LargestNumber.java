import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    static class SortNumbers implements Comparator<String> {

        @Override
        public int compare(String num1, String num2) {
            String Option1 = num1 + num2;
            String Option2 = num2 + num1;
            return Option2.compareTo(Option1);
        }
    }


    public static String largestNumber(int[] nums) {
        String[] numbers = new String[nums.length];

        for(int i=0; i<nums.length; i++) {
            numbers[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numbers, new SortNumbers());

        if(numbers[0].equals("0")) {
            return "0";
        }

        StringBuilder ans = new StringBuilder();
        for (String number : numbers) {
            ans.append(number);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{3,30,34,5,9}));
    }
}
