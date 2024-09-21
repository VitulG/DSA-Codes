import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {

    public static void helper(int currentNumber, int num, List<Integer> ans) {
        if(currentNumber > num) {
            return;
        }
        ans.add(currentNumber);

        for(int i=0; i<=9; i++) {
            int newNumber = (currentNumber*10) + i;
            if(newNumber > num) {
                return;
            }
            helper(newNumber, num, ans);
        }
    }

    public static List<Integer> lexicalOrder(int num) {
        List<Integer> ans = new ArrayList<>();

        for(int i=1; i<=9; i++) {
            helper(i, num, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lexicalOrder(13));
    }
}
