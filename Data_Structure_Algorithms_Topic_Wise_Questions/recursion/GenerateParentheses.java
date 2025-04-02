package Data_Structure_Algorithms_Topic_Wise_Questions.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void generateValidParenthesis(int num, int open, int close, StringBuilder curr, List<String> parentheses) {
        if(curr.length() == 2 * num) {
            parentheses.add(curr.toString());
            return;
        }

        if(open < num) {
            curr.append("(");
            generateValidParenthesis(num, open+1, close, curr, parentheses);
            curr.deleteCharAt(curr.length()-1);
        }

        if(close < open) {
            curr.append(")");
            generateValidParenthesis(num, open,close+1, curr, parentheses);
            curr.deleteCharAt(curr.length()-1);
        }
    }

    public static List<String> generateParenthesis(int n) {
        if(n == 0) {
            return new ArrayList<>();
        }
        List<String> parentheses = new ArrayList<>();
        generateValidParenthesis(n, 0, 0, new StringBuilder(), parentheses);
        return parentheses;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }
}
