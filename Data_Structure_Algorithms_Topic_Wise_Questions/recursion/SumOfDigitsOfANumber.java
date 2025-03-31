package Data_Structure_Algorithms_Topic_Wise_Questions.recursion;

public class SumOfDigitsOfANumber {

    public static int sumOfDigits(int n) {
        if(n <= 0) {
            return 0;
        }
        return n%10 + sumOfDigits(n/10);
    }

    public static void main(String[] args) {
        System.out.println(sumOfDigits(99999));
    }
}
