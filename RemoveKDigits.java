import java.util.Stack;

public class RemoveKDigits {
    public static String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<Character>();

        for(int i=0; i<num.length(); i++) {
            char ch = num.charAt(i);

            while(!stack.isEmpty() && k > 0 && stack.peek() > ch) {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }

        while(!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder ans = new StringBuilder("");
        while(!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        while(ans.length() > 1 && ans.charAt(ans.length()-1) == '0') {
            ans.deleteCharAt(ans.length()-1);
        }
        return (ans.length() == 0) ? "0" : ans.reverse().toString();

    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("100", 1));
    }
}