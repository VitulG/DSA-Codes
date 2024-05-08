import java.util.Comparator;
import java.util.PriorityQueue;

public class RelativeRanks {

    static class Pair {
        int athlete;
        int score;

        public Pair(int athlete, int score) {
            this.athlete = athlete;
            this.score = score;
        }

    }

    static class SortPairs implements Comparator<Pair> {

        @Override
        public int compare(Pair p1, Pair p2) {
            return p2.score - p1.score;
        }
        
    }

    public static String[] findRelativeRanks(int[] score) {
        if(score.length == 1) {
            return new String[]{"Gold Medal"};
        }
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>(new SortPairs());

        for(int i=0; i<score.length; i++) {
            queue.offer(new Pair(i, score[i]));
        }

        String[] rank = new String[score.length];

        if(!queue.isEmpty()) {
            Pair first = queue.poll();
            rank[first.athlete] = "Gold Medal";
        }

        if(!queue.isEmpty()) {
            Pair second = queue.poll();
            rank[second.athlete] = "Silver Medal";
        }

        if(!queue.isEmpty()) {
            Pair third = queue.poll();
            rank[third.athlete] = "Bronze Medal";
        }

        int pos = 4;

        while(!queue.isEmpty()) {
            Pair position = queue.poll();
            rank[position.athlete] = Integer.toString(pos);
            pos++;
        }
        return rank;

    }


    public static void main(String[] args) {
        String[] result = findRelativeRanks(new int[]{5,3});

        for(String rank : result) {
            System.out.print(rank +" ");
        }
    }
}