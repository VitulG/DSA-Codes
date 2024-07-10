import java.util.Stack;

public class CrawlerLogFolder {
    public static int minOperations(String[] logs) {
        if(logs.length == 0) {
            return 0;
        }

        Stack<String> stack = new Stack<String>();

        for(String log : logs) {
            if(log.equals("./")) {
                continue;
            }else if(log.equals("../")) {
                if(stack.isEmpty()) {
                    continue;
                }else{
                    stack.pop();
                }
            }else{
                stack.push(log);
            }
        }
        return stack.size();
    }
    
    public static void main(String[] args) {
        System.out.println(minOperations(new String[]{"d1/","../","../","../"}));
    }
}
