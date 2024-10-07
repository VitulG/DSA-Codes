import java.util.Stack;

public class MinimumStringLengthAfterRemovingSubstrings {

    public static int minLength(String str) {
        Stack<Character> stack = new Stack<>();
        for(char ch : str.toCharArray()) {
            if(!stack.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                sb.append(stack.peek()).append(ch);
                if(sb.toString().equals("AB") || sb.toString().equals("CD")) {
                    stack.pop();
                }else{
                    stack.push(ch);
                }
            }else {
                stack.push(ch);
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        System.out.println(minLength("ACBBD"));
    }
}
