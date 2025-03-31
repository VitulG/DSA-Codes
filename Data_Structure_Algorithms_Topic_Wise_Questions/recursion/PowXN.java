package Data_Structure_Algorithms_Topic_Wise_Questions.recursion;

public class PowXN {

    public static double powerFunc(double num, int pow) {
        if(pow == 0) {
            return 1.0d;
        }

        double val = powerFunc(num, pow/2);

        if((pow&1) != 0) {
            return num*val*val;
        }
        return val*val;
    }

    public static double myPow(double x, int n) {
        boolean isPowerNegative = n < 0;
        double value = powerFunc(x, Math.abs(n));
        return (isPowerNegative) ? 1 / value : value;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.00000, 10));
    }
}
