public class SumOfSquareNumbers {

    public static boolean judgeSquareSum(int c) {
        long left = 0;
        long right = (long) Math.sqrt(c);
        
        while(left <= right) {
            long square = (left * left) + (right * right);

            if(square == c) {
                return true;
            }

            if(square < c) {
                left++;
            }else {
                right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(2147483600));

    }    
}
