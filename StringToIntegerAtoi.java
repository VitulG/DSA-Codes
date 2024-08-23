public class StringToIntegerAtoi {

    public static int myAtoi(String str) {
        if(str.isEmpty()) {
            return 0;
        }

        int size = str.length();
        int idx = 0;

        while(idx < size && str.charAt(idx) == ' ') {
            idx++;
        }

        if(idx == size) {
            return 0;
        }

        boolean isNegative = false;

        if(str.charAt(idx) == '+' || str.charAt(idx) == '-') {
            isNegative = (str.charAt(idx) == '-');
            idx++;
        }

        int ans = 0;

        while(idx < size && Character.isDigit(str.charAt(idx))) {
            int val = str.charAt(idx) - '0';

            if(ans > (Integer.MAX_VALUE - val) / 10) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            ans = (ans*10) + val;
            idx++;
        }

        return isNegative ? -ans : ans;

    }

    public static void main(String[] args) {
        System.out.println(myAtoi("words and 987"));
    }
}