public class FindNumbersWithEvenNumberOfDigits {

    public static int findNumberDigits(int num) {
        int digits = 0;

        while(num != 0) {
            digits++;
            num /= 10;
        }
        return digits;
    }

    public static int findNumbers(int[] nums) {
        int count = 0;

        for(int num : nums) {
            int digits = findNumberDigits(num);

            if((digits&1) == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findNumbers(new int[]{12,345,2,6,7896}));
    }
}
