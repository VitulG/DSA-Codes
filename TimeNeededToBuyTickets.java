import java.util.ArrayDeque;
import java.util.Queue;

public class TimeNeededToBuyTickets {

    public static int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> queue = new ArrayDeque<>();

        int persons = tickets.length;

        for(int i=0; i<persons; i++) {
            queue.add(i);
        }

        int time = 0;

        while(tickets[k] > 0) {
            int person = queue.poll();
            tickets[person] -= 1;
            time++;
            if(tickets[person] > 0) {
                queue.offer(person);
            }
        }
        return time;
        
    }


    public static void main(String[] args) {
        System.out.println(timeRequiredToBuy(new int[]{84,49,5,24,70,77,87,8}, 0));
    }


}