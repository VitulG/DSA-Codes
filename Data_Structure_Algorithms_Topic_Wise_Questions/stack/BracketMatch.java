package Data_Structure_Algorithms_Topic_Wise_Questions.stack;

import java.util.Stack;

public class BracketMatch {

    public static int bracketMatch(String text) {
        if(text.isEmpty()) {
            return 0;
        }
        Stack<Character> stack = new Stack<>();

        for(char ch : text.toCharArray()) {
            if(ch == '(') {
                stack.push(ch);
            }else {
                if(!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }else {
                    stack.push(ch);
                }
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {

    }
}
