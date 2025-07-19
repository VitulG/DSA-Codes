package Data_Structure_Algorithms_Topic_Wise_Questions.arrays_strings;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public static List<String> fizzBuzz(int n) {
        if(n == 0) {
            return new ArrayList<>();
        }

        List<String> ans = new ArrayList<>();

        for(int i=1; i<=n; i++) {
            if(i%3 == 0 && i%5 == 0) {
                ans.add("FizzBuzz");
            }else if(i%3==0) {
                ans.add("Fizz");
            }else if(i%5==0) {
                ans.add("Buzz");
            }else {
                ans.add(String.valueOf(i));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(fizzBuzz(15));
    }
}
