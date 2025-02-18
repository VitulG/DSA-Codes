import java.util.Stack;

public class ConstructSmallestNumberFromDIString {

    public static String smallestNumber(String pattern) {

        // Brute force approach is to generate all the string and check the pattern
        // Time complexity will be generating all the staring will be n! and check patter will be n
        // overall time complexity will be O(n*n!)

        int counter = 1;

        StringBuilder ans = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<=pattern.length(); i++) {
            stack.push(counter);
            counter++;

            if(i < pattern.length() && pattern.charAt(i) == 'I' ) {
                while(!stack.isEmpty()) {
                    ans.append(stack.pop());
                }
            }
        }

        while(!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        return ans.toString();

        // using stack TC will be -> O(n)
    }

    public static void main(String[] args) {
        System.out.println(smallestNumber("IIDIDI"));
    }
}
