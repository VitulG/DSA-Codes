package Data_Structure_Algorithms_Topic_Wise_Questions.dynamic_programming.one_d;

public class NthTribonacciNumber {

    public static int tribonacci(int num) {
        if(num == 0) {
            return 0;
        }

        if(num == 1 || num == 2) {
            return 1;
        }

        int first = 0;
        int second = 1;
        int third = 1;

        for(int i=3; i<=num; i++) {
            int sum = first + second + third;
            first = second;
            second = third;
            third = sum;
        }
        return third;
    }

    public static void main(String[] args) {
        System.out.println(tribonacci(4));
    }
}
