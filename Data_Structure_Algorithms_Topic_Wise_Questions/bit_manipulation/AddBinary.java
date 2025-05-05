package Data_Structure_Algorithms_Topic_Wise_Questions.bit_manipulation;

public class AddBinary {

    /*
        Approach is to use simple addition operation while it is in the binary form instead of using 10 we have to use 2
            TC -> O(Math.max(a, b)) SC-> O(n) SC -> for using StringBuilder
     */

    public static String addBinary(String a, String b) {
        if(a.isEmpty()) {
            return b;
        }

        if(b.isEmpty()) {
            return a;
        }

        int carry = 0;
        int aLen = a.length()-1;
        int bLen = b.length()-1;

        StringBuilder ans = new StringBuilder();

        while(aLen >= 0 || bLen >=0) {
            int sum = carry;

            if(aLen >= 0) {
                sum += (a.charAt(aLen)-'0');
            }

            if(bLen >= 0) {
                sum += (b.charAt(bLen)-'0');
            }
            carry = sum / 2;
            ans.append(sum%2);
            aLen--;
            bLen--;
        }

        if(carry > 0) {
            ans.append(carry);
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
    }
}
