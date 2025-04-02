package Data_Structure_Algorithms_Topic_Wise_Questions.recursion;

public class PowerOfNumbers {

    public static int reverseNumber(int num) {
        int reversed = 0;
        while(num != 0) {
            int rem = num % 10;
            reversed = (reversed*10) + rem;
            num /= 10;
        }
        return reversed;
    }

    public static int powFunc(int num, int pow) {
        if(pow == 0) {
            return 1;
        }

        int value = powFunc(num, pow/2);

        if((pow&1) != 0) {
            return value * value * num;
        }
        return value * value;
    }

    public static int reverseExponentiation(int n) {
        if(n == 1 || n == 10) {
            return n;
        }
        int reversePow = reverseNumber(n);
        return powFunc(n, reversePow);
    }

    public static void main(String[] args) {
        System.out.println(reverseExponentiation(3));
    }
}
