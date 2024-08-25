import java.util.Stack;

public class MaximumScoreFromRemovingSubstrings {
    private static String currState;

    public static int getMaxPoints(String str, int points, String target) {
        int ans = 0;
        Stack<Character> stack = new Stack<Character>();

        for(char ch : str.toCharArray()) {
            String curr = (stack.isEmpty()) ? Character.toString(ch) : new String(stack.peek().toString()) + ch;

            if(curr.equals(target)) {
                ans += points;
                stack.pop();
            }else{
                stack.push(ch);
            }
        }

        StringBuilder updatedString = new StringBuilder("");

        while(!stack.isEmpty()) {
            updatedString.append(stack.pop());
        }
        
        currState = updatedString.reverse().toString(); 

        return ans;
    }

    public static int maximumGain(String str, int x, int y) {
        int ans = 0;

        ans += (x < y) ? getMaxPoints(str, y, "ba") : getMaxPoints(str, x, "ab");
        str = currState;
        ans += (x < y) ? getMaxPoints(str, x, "ab") : getMaxPoints(str, y, "ba");

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maximumGain("cdbcbbaaabab", 4, 5));
    }

}