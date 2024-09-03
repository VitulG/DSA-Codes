public class SumOfDigitsOfStringAfterConvert {

    public static int getLucky(String str, int k) {
        if(str == null || str.isEmpty()) {
            return 0;
        }

        StringBuilder sb = new StringBuilder();

        for(char ch : str.toCharArray()) {
            int value = ch - 'a'+1;
            sb.append(value);
        }

        if(k == 0) {
            return Integer.parseInt(sb.toString());
        }

        while(k > 0 && sb.length() > 1) {
            int sum = 0;
            for(char ch : sb.toString().toCharArray()) {
                sum += ch - '0';
            }
            sb.setLength(0);
            sb.append(sum);
            k--;
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(getLucky("zbax", 2));
    }
}
