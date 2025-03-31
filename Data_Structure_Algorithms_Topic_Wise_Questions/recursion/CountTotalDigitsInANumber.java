package Data_Structure_Algorithms_Topic_Wise_Questions.recursion;

public class CountTotalDigitsInANumber {

    public static int countDigits(int num) {
        if(num <= 0) {
            return 0;
        }
        return 1 + countDigits(num / 10);
    }

    public static void main(String[] args) {
        System.out.println(countDigits(4567));
    }
}
