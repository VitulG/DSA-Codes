public class NthTribonacciNumber {
    public static int tribonacci(int n) {

        if(n <= 0) {
            return 0;
        }

        if(n==1 || n==2) {
            return 1;
        }

        int first = 0;
        int second = 1;
        int third = 1;

        for(int i=3; i<=n; i++) {
            int next = first + second + third;
            first = second;
            second = third;
            third = next;
        }
        return third;
    }

    public static void main(String[] args) {
        System.out.println(tribonacci(8));
    }
}
