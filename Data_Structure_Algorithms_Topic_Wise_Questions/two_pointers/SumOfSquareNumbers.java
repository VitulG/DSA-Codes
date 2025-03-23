package Data_Structure_Algorithms_Topic_Wise_Questions.two_pointers;

public class SumOfSquareNumbers {

    public static boolean judgeSquareSum(int c) {
        if(c < 0) {
            return false;
        }

        int lo = 0;
        int hi = (int) Math.sqrt(c);

        while (lo <= hi) {
            long result = (long) lo * lo + (long) hi * hi;
            if(result == c) {
                return true;
            }else if(result < c) {
                lo++;
            }else {
                hi--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(4));
    }
}
