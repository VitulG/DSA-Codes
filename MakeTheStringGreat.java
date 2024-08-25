import java.util.Stack;

public class MakeTheStringGreat {

    public static String makeGood(String str){

        if(str.length() == 1) {
            return str;
        }

        Stack<Character> stack = new Stack<Character>();

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);

            if(!stack.isEmpty() && Math.abs(ch - stack.peek()) == 32) {
                stack.pop();
            }else{
                stack.push(ch);
            }
        }

        StringBuilder ans = new StringBuilder("");

        while(!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        return ans.reverse().toString();

    }


    public static void main(String[] args) {
        System.out.println(makeGood("s"));
    }

    
}