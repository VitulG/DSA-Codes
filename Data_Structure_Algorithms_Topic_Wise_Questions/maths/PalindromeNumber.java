package Data_Structure_Algorithms_Topic_Wise_Questions.maths;

public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }

        int temp = x;
        int reversed = 0;

        while(temp != 0) {
            int rem = temp % 10;
            reversed = (reversed * 10) + rem;
            temp /= 10;
        }
        return reversed == x;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
    }
}
