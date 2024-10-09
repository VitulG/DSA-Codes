import java.util.Stack;

public class MinimumAddToMakeParenthesesValid {

    public static int minAddToMakeValid(String str) {
        if(str.isEmpty()) {
            return 0;
        }

        Stack<Character> stack = new Stack<>();

        for(char ch : str.toCharArray()) {
            if(!stack.isEmpty() && stack.peek() == '(' && ch == ')') {
                stack.pop();
            }else {
                stack.push(ch);
            }
        }
        return stack.size();

    }

    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("())")); // Output: 1
        System.out.println(minAddToMakeValid("(((")); // Output: 3
        System.out.println(minAddToMakeValid("()())()")); // Output: 1
        System.out.println(minAddToMakeValid("")); // Output: 0
    }
}
