import java.util.ArrayDeque;
import java.util.Queue;

public class FindTheWinnerOfTheCircularGame{
    public static int findTheWinner(int n, int k) {
        Queue<Integer> queue = new ArrayDeque<Integer>();

        for(int i=1; i<=n; i++) {
            queue.offer(i);
        }

        int friends = 0;

        while(queue.size() != 1) {
            int friend = queue.poll();
            friends++;

            if(friends == k) {
                friends = 0;
            }else {
                queue.offer(friend);
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        System.out.println(findTheWinner(6, 5));
    }
}
