package Data_Structure_Algorithms_Topic_Wise_Questions.arrays_strings;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class GameWithString {

    /*
        Approach:
            - The goal is to minimize the sum of squares of character frequencies after removing 'k' characters.

                1. Count the frequency of each character using a HashMap.
                2. Add all frequencies into a Max Heap (PriorityQueue with reverse comparator).
                3. Perform 'k' operations:
                   - Each time, remove the character with the highest frequency.
                   - Decrease its frequency by 1 and add it back to the heap if it's still non-zero.
                4. After all removals, compute the sum of squares of the remaining frequencies in the heap.

            Time Complexity:
                - O(n) to count frequencies.
                - O(k log 26) ≈ O(k) for removing characters from heap (since max 26 characters).
                - Final heap traversal is O(26) ≈ O(1).
                - So, **Total Time Complexity** = O(n + k)

            Space Complexity:
                - O(26) for the frequency map and heap => **O(1)** auxiliary space.
                - If we consider input storage, it's **O(n)**.

            Final:
                TC -> O(n + k)
                SC -> O(1) auxiliary (O(n) if input counted)
     */

    static class Pair {
        char ch;
        int freq;

        public Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    static class SortPairs implements Comparator<Pair> {

        @Override
        public int compare(Pair p1, Pair p2) {
            if(p1.freq == p2.freq) {
                return p2.ch - p1.ch;
            }
            return p2.freq - p1.freq;
        }
    }

    public static int minValue(String s, int k) {
        if(s.isEmpty() || k > s.length()) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+ 1);
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>(new SortPairs());

        for(Map.Entry<Character, Integer> en : map.entrySet()) {
            char key = en.getKey();
            int freq = en.getValue();

            queue.offer(new Pair(key, freq));
        }

        while(!queue.isEmpty() && k-- > 0) {
            Pair largestFreqPair = queue.poll();
            largestFreqPair.freq = largestFreqPair.freq - 1;

            if(largestFreqPair.freq != 0) {
                queue.offer(largestFreqPair);
            }
        }

        int ans = 0;

        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            ans += (pair.freq * pair.freq);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minValue("aaab", 2));
    }
}
