import java.util.PriorityQueue;

class Pair {
    char ch;
    int freq;

    public Pair(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}

public class LongestHappyString {

    public static String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> queue = new PriorityQueue<>((el1, el2) -> el2.freq - el1.freq);

        if (a > 0) {
            queue.offer(new Pair('a', a));
        }
        if (b > 0) {
            queue.offer(new Pair('b', b));
        }
        if (c > 0) {
            queue.offer(new Pair('c', c));
        }

        StringBuilder longestHappyString = new StringBuilder();

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            // Check if we are adding a third consecutive character
            if (longestHappyString.length() >= 2 &&
                    longestHappyString.charAt(longestHappyString.length() - 1) == pair.ch &&
                    longestHappyString.charAt(longestHappyString.length() - 2) == pair.ch) {

                // Try to add a different character
                if (queue.isEmpty()) {
                    break; // No other characters left to add
                }

                Pair newPair = queue.poll();
                longestHappyString.append(newPair.ch);

                // Decrement and reinsert if there are occurrences left
                if (--newPair.freq > 0) {
                    queue.offer(new Pair(newPair.ch, newPair.freq));
                }

                // Reinsert the original character back into the queue
                queue.offer(new Pair(pair.ch, pair.freq));
            } else {
                // Add the current character
                longestHappyString.append(pair.ch);

                // Decrement and reinsert if there are occurrences left
                if (--pair.freq > 0) {
                    queue.offer(new Pair(pair.ch, pair.freq));
                }
            }
        }
        return longestHappyString.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestDiverseString(1,1,7));
    }
}
