package Data_Structure_Algorithms_Topic_Wise_Questions.maths;

public class SqrtX {
    public static int mySqrt(int x) {
        if(x == 0 || x == 1) {
            return x;
        }

        long low = 1;
        long high = x/2;

        long sqrt = 0;

        while(low <= high) {
            long mid = low + (high - low) / 2;

            if(mid * mid <= x) {
                sqrt = mid;
                low = mid + 1;
            }else {
                high = mid - 1;
            }

        }
        return (int) sqrt;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(178));
    }
}
