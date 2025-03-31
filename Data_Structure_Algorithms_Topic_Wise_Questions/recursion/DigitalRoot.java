package Data_Structure_Algorithms_Topic_Wise_Questions.recursion;

public class DigitalRoot {

    public static int getNumberSum(int num) {
        if(num <= 0) {
            return 0;
        }
        return num % 10 + getNumberSum(num/10);
    }

    public static int getDigitRoot(int sum, int digitRoot) {
        if(sum <= 0) {
            return digitRoot;
        }

        digitRoot += sum % 10;

        return getDigitRoot(sum/10, digitRoot);
    }

    // complete the function
    public static int digitalRoot(int n)
    {
        // add your code here
        if(n < 10) {
            return n;
        }

        int sum = getNumberSum(n);

        if(sum < 10) {
            return sum;
        }

        while(sum >= 10) {
            sum = getDigitRoot(sum, 0);
        }
        return sum;

        // we can do this in O(1) time the formula is => 1 + (n-1%9) where n != 0
    }

    public static void main(String[] args) {
        System.out.println(digitalRoot(8426693));
    }
}
