package Data_Structure_Algorithms_Topic_Wise_Questions.recursion;

public class LuckyNumbers {

    public static boolean isLuckyNumber(int num, int pass) {
        if(num < pass) {
            return true;
        }

        if(num % pass == 0) {
            return false;
        }
        return isLuckyNumber(num - num / pass, pass+1);
    }

    public static boolean isLucky(int num) {
        return isLuckyNumber(num, 2);
    }

    public static void main(String[] args) {
        System.out.println(isLucky(19));
    }
}
