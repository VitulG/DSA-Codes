import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class NumberOfStudentsUnableToEatLunch {

    public static int countStudents(int[] students, int[] sandwitches) {
        Stack<Integer> stack = new Stack<Integer>();
        Queue<Integer> queue = new ArrayDeque<Integer>();

        for(int student : students) {
            queue.offer(student);
        }

        for(int i=sandwitches.length-1; i>=0; i--) {
            stack.push(sandwitches[i]);
        }

        int it = 0;

        while(!stack.isEmpty() && it < queue.size()) {
            if(stack.peek() == queue.peek()) {
                stack.pop();
                queue.poll();
                it = 0;
            }else{
                int front = queue.poll();
                queue.offer(front);
                it++;
            }
        }
        return queue.size();

    }


    public static void main(String[] args) {
        System.out.println(countStudents(new int[]{1,1,1,0,0,1}, new int[]{1,0,0,0,1,1}));
    }
    
}
