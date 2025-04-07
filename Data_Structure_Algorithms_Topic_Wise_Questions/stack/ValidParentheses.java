package Data_Structure_Algorithms_Topic_Wise_Questions.stack;

import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String str) {
        if(str.isEmpty()) {
            return true;
        }

        Stack<Character> stack = new Stack<>();

        for(char ch : str.toCharArray()) {
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }else {
                if(!stack.isEmpty() && ch == ')' && stack.peek() != '(') {
                    return false;
                }else if(!stack.isEmpty() && ch == '}' && stack.peek() != '{') {
                    return false;
                }else if(!stack.isEmpty() && ch == ']' && stack.peek() != '[') {
                    return false;
                }else if(stack.isEmpty()) {
                    return false;
                }else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("(]"));
    }
}
