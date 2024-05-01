import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class RevealCardsInIncreasingOrder {

    public static int[] deckRevealedIncreasing(int[] deck) {
        int size = deck.length;

        if(size <= 1) {
            return deck;
        }

        Queue<Integer> queue = new ArrayDeque<Integer>();
        for(int i=0; i<size; i++) {
            queue.offer(i);
        }

        Arrays.sort(deck);
        int idx = 0;

        int[] order = new int[size];

        while(!queue.isEmpty()) {
            int currIdx = queue.poll();
            order[currIdx] = deck[idx++];
            if(!queue.isEmpty()) {
                queue.offer(queue.poll());
            }
        }
        return order;

    }

    public static void main(String[] args) {
        int[] result = deckRevealedIncreasing(new int[]{17,13,11,2,3,5,7});

        for(int i : result) {
            System.out.print(i+" ");
        }
    }
}