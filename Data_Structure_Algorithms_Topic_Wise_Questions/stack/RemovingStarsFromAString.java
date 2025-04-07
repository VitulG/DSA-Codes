package Data_Structure_Algorithms_Topic_Wise_Questions.stack;

import java.util.Stack;

public class RemovingStarsFromAString {

    public static String removeStars(String str) {
        if(str.isEmpty()) {
            return "";
        }

        Stack<Character> stack = new Stack<>();

        for(char ch : str.toCharArray()) {
            if (ch == '*') {
                stack.pop();
            }else {
                stack.push(ch);
            }
        }

        StringBuilder ans = new StringBuilder();

        while(!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(removeStars("erase*****"));
    }
}
