import java.util.Stack;

public class MaximumNestingDepthOfTheParentheses {

    public static int maxDepth(String str) {
        Stack<Character> stack = new Stack<Character>();
        int depth = 0;

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == '(') {
                stack.push(ch);
                depth = (stack.size() > depth) ? stack.size() : depth;
            }

            if(ch == ')') {
                stack.pop();
            }
        }
        return depth;
    }
}