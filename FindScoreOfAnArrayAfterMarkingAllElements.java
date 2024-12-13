import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class FindScoreOfAnArrayAfterMarkingAllElements {
    static class Pair {
        int score;
        int index;

        public Pair(int score, int index) {
            this.score = score;
            this.index = index;
        }
    }

    public static long findScore(int[] nums) {
        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return p1.score == p2.score ? (p1.index - p2.index) : (p1.score - p2.score);
            }
        });

        for(int i=0; i<nums.length; i++) {
            queue.offer(new Pair(nums[i], i));
        }

        long score = 0L;
        Set<Integer> markedIndices = new HashSet<>();

        while(!queue.isEmpty()) {
            Pair pair = queue.poll();

            if(!markedIndices.contains(pair.index)) {
                score += pair.score;
                int idx = pair.index;
                markedIndices.add(idx);
                if(idx >= 0) markedIndices.add(idx-1);
                if(idx < nums.length) markedIndices.add(idx+1);
            }
        }
        return score;

    }

    public static void main(String[] args) {
        System.out.println(findScore(new int[]{2,3,5,1,3,2}));
    }
}
