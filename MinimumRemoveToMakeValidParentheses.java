// import java.util.HashSet;
// import java.util.Set;
// import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {

    public static String minRemoveToMakeValid(String str) {
        // with stack 
        // Stack<Integer> stack = new Stack<Integer>();
        // Set<Integer> set = new HashSet<Integer>();

        // for(int i=0; i<str.length(); i++) {
        //     char ch = str.charAt(i);

        //     if(ch == '(') {
        //         stack.push(i);
        //     }else if(ch == ')') {
        //         if(stack.isEmpty()) {
        //             set.add(i);
        //         }else{
        //             stack.pop();
        //         }
        //     }
        // }

        // while(!stack.isEmpty()) {
        //     set.add(stack.pop());
        // }

        // StringBuilder ans = new StringBuilder("");

        // for(int i=0; i<str.length(); i++) {
        //     if(!set.contains(i)) {
        //         ans.append(str.charAt(i));
        //     }
        // }
        // return ans.toString();

        // without stack
        int open = 0;
        StringBuilder upd1 = new StringBuilder("");

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);

            if(ch >= 97 && ch <= 122) {
                upd1.append(ch);
            }else if(ch == '(') {
                open+=1;
                upd1.append(ch);
            }else if(open > 0) {
                open-=1;
                upd1.append(ch);
            }
        }

        int close = 0;
        StringBuilder upd2 = new StringBuilder("");

        for(int i=upd1.length()-1; i >=0; i--) {
            char ch = upd1.charAt(i);

            if(ch >= 97 && ch <= 122) {
                upd2.append(ch);
            }else if(ch == ')') {
                close+=1;
                upd2.append(ch);
            }else if(close > 0) {
                close-=1;
                upd2.append(ch);
            }
        }
        return upd2.reverse().toString();

    }

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("(a(b(c)d)"));
    }
}