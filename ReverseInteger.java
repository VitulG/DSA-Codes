public class ReverseInteger{

    public static int reverse(int num) {

        long temp = num;
        long ans = 0;

        while(temp != 0) {

            long rem = temp % 10;
            ans = (ans*10) + rem;
            temp/=10;

        }
        if(ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE) return 0;
        return (int) ans;

    }

    public static void main(String[] args) {
        
        System.out.println(reverse(-120));

    }


}