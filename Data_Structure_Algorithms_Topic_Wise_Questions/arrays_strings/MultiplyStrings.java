package Data_Structure_Algorithms_Topic_Wise_Questions.arrays_strings;

public class MultiplyStrings {

    public static String getMultiply(String num1, int digit) {
        int carry = 0;
        StringBuilder curr = new StringBuilder();

        for(int i= num1.length()-1; i>= 0; i--) {
            int num = num1.charAt(i) - '0';
            int multiply = (num * digit) + carry;
            carry = multiply / 10;
            curr.append(multiply % 10);
        }

        if(carry > 0) {
            curr.append(carry);
        }

        return curr.reverse().toString();
    }

    public static String addStringResult(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) sum += num1.charAt(i--) - '0';
            if (j >= 0) sum += num2.charAt(j--) - '0';
            sb.append(sum % 10);
            carry = sum / 10;
        }

        return sb.reverse().toString();
    }

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        if(num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        int level = 0;
        String ans = "0";

        for(int i=num2.length()-1; i>=0; i--) {
            int digit = num2.charAt(i) - '0';
            String product = getMultiply(num1, digit);

            ans = addStringResult(ans, getMultiply(num1, digit) + "0".repeat(Math.max(0, level)));
            level++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(multiply("1","456"));
    }
}
