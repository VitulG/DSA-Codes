package Data_Structure_Algorithms_Topic_Wise_Questions.recursion;

public class Print1ToNUsingRecursion {

    public static void printNumbers(int i, int num) {
        if(i > num) {
            return;
        }
        System.out.print(i+" ");
        printNumbers(i+1, num);
    }

    public static void printNum(int num) {
        printNumbers(1, num);
    }

    public static void main(String[] args) {
        printNum(100);
    }
}
