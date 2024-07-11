import java.util.Stack;

public class ReverseSubstringsBetweenEachPairOfParentheses {

    public static String reverseParentheses(String str) {
        if(str == null || str.isEmpty()) {
            return "";
        }
        StringBuilder revString = new StringBuilder("");
        Stack<StringBuilder> stack = new Stack<StringBuilder>();

        for(char ch : str.toCharArray()) {
            if(ch == '(') {
                stack.push(revString);
                revString = new StringBuilder();
            }else if(ch == ')') {
                revString.reverse();
                StringBuilder prev = stack.pop();
                prev.append(revString);
                revString = prev;
            }else {
                revString.append(ch);
            }
        }
        return revString.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseParentheses("(ed(et(oc))el)"));
    }

}
