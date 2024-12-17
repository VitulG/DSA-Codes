import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ConstructStringWithRepeatLimit {
    static class Pair {
        char ch;
        int freq;

        public Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    public static String repeatLimitedString(String str, int repeatLimit) {
        if(str.length() == 1) {
            return str;
        }

        Map<Character, Integer> map = new HashMap<>();
        for(char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) +1);
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> b.ch - a.ch);

        for(Map.Entry<Character, Integer> en : map.entrySet()) {
            char key = en.getKey();
            int value = en.getValue();

            queue.offer(new Pair(key, value));
        }

        StringBuilder ans = new StringBuilder();

        while(!queue.isEmpty()) {
            Pair pair = queue.poll();

            char key = pair.ch;
            int freq = pair.freq;

            for(int i=0; i<Math.min(freq, repeatLimit); i++) {
                ans.append(key);
            }

            freq -= Math.min(freq, repeatLimit);

            if(freq > 0) {
                if(queue.isEmpty()) {
                    break;
                }
                Pair nextGreater = queue.poll();
                char nextCh = nextGreater.ch;
                int nextChFreq = nextGreater.freq;

                ans.append(nextCh);
                nextChFreq--;

                if(nextChFreq > 0) {
                    queue.offer(new Pair(nextCh, nextChFreq));
                }
                queue.offer(new Pair(key, freq));
            }
        }
        return ans.toString();

        // Time Complexity => O(n + n log k)
        // Space Complexity => O(52) 26 will contain by map and rest will be in the heap so it will be O(1)

    }

    public static void main(String[] args) {
        System.out.println(repeatLimitedString("acdeaacdd", 2));
    }
}
