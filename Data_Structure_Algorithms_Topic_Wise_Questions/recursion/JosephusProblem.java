package Data_Structure_Algorithms_Topic_Wise_Questions.recursion;

public class JosephusProblem {

    public static int getFinalPerson(int n, int k) {
        if(n == 0) {
            return 0;
        }
        return (getFinalPerson(n-1, k) + k) % n;
    }

    public static int josephus(int n, int k) {
        return getFinalPerson(n, k) + 1;
    }

    public static void main(String[] args) {
        System.out.println(josephus(7,4));
    }
}
