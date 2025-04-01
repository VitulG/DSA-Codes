package Data_Structure_Algorithms_Topic_Wise_Questions.recursion;

public class SumOfFirstNNaturalNumbersUsingRecursion {

    public static int naturalNumberSum(int num) {
        if(num == 0) {
            return 0;
        }
        return num + naturalNumberSum(num-1);
    }

    public static void main(String[] args) {
        System.out.println(naturalNumberSum(5));
    }
}
