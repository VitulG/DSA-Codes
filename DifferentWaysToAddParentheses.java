import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {

    public static List<Integer> helper(String expression) {
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<expression.length(); i++) {
            if(expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
                List<Integer> leftResult = helper(expression.substring(0, i));
                List<Integer> rightResult = helper(expression.substring(i+1));

                for(int l : leftResult) {
                    for(int r : rightResult) {
                        if(expression.charAt(i) == '+') {
                            result.add(l + r);
                        } else if(expression.charAt(i) == '-') {
                            result.add(l - r);
                        } else if(expression.charAt(i) == '*') {
                            result.add(l * r);
                        }
                    }
                }
            }
        }
        if(result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }
        return result;
    }

    public static List<Integer> diffWaysToCompute(String expression) {
        // Your code here
        return helper(expression);
    }

    public static void main(String[] args) {
        System.out.println(diffWaysToCompute("2*3-4*5"));
    }
}
