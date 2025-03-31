package Data_Structure_Algorithms_Topic_Wise_Questions.recursion;

public class PrintNTo1UsingRecursion {

    public static void printNum(int num) {
        if(num <= 0) {
            return;
        }
        System.out.print(num+" ");
        printNum(num-1);
    }

    public static void main(String[] args) {
        printNum(10);
    }
}
