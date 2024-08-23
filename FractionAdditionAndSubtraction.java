public class FractionAdditionAndSubtraction {

    public static int findGCD(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return findGCD(num2, num1 % num2);
    }

    public static String fractionAddition(String expression) {
        if(expression == null || expression.isEmpty()) {
            return "";
        }

        int numerator = 0;
        int denominator = 1;

        int idx = 0;
        int size = expression.length();

        while(idx < size) {
            boolean isNegative = (expression.charAt(idx) == '-');

            int currNumerator = 0;
            int currDenominator = 0;

            if(expression.charAt(idx) == '+' || expression.charAt(idx) == '-') {
                idx++;
            }

            while(idx < size && Character.isDigit(expression.charAt(idx))) {
                int val = expression.charAt(idx)-'0';
                currNumerator = (currNumerator*10)+val;
                idx++;
            }

            if(isNegative) {
                currNumerator *= -1;
            }

            idx++; // for the division symbol

            while(idx < size && Character.isDigit(expression.charAt(idx))) {
                int val = expression.charAt(idx)-'0';
                currDenominator = (currDenominator*10) + val;
                idx++;
            }

            numerator = numerator * currDenominator + currNumerator * denominator;
            denominator = denominator * currDenominator;
        }

        int gcd = Math.abs(findGCD(numerator, denominator));

        numerator /= gcd;
        denominator /= gcd;

        return new String(numerator+"/"+denominator);
        
    }

    public static void main(String[] args) {
        System.out.println(fractionAddition("1/3-1/2"));
    }
}