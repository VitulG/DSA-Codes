import java.util.Collections;
import java.util.PriorityQueue;

public class TakeGiftsFromTheRichestPile {
    public static long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxGifts = new PriorityQueue<>(Collections.reverseOrder());

        for(int gift : gifts) { // TC => n log n
            maxGifts.offer(gift);
        }

        while(k-- > 0 && !maxGifts.isEmpty()) { // TC => k log n
            int maxGift = maxGifts.poll();
            int remainingGift =  (int) Math.floor(Math.sqrt(maxGift));
            maxGifts.offer(remainingGift);
        }

        long ans = 0L;

        while(!maxGifts.isEmpty()) { // TC => k log n
            ans += maxGifts.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(pickGifts(new int[]{25,64,9,4,100}, 4));
    }
}
