package Data_Structure_Algorithms_Topic_Wise_Questions.graph;

import java.util.*;

public class AlienDictionary {

    /*
        Approach: Alien Dictionary using Topological Sort (Kahn's Algorithm)
        --------------------------------------------------------------------

        To determine the character order in an alien language from a sorted dictionary:

            1. **Graph Construction**:
               - Initialize a graph and an `in_degree` map for each unique character in all words.

            2. **Compare Adjacent Words**:
               - For every adjacent pair of words (prev, curr), find the **first mismatch**.
                 a. The character from `prev` comes before the one in `curr`, so create a directed edge.
                 b. Increment `in_degree` of the destination character.
               - If no mismatch is found and `prev.length() > curr.length()`, the order is invalid → return `""`.

            3. **Topological Sort using Kahn’s Algorithm**:
               - Add all characters with `in_degree = 0` to a queue.
               - Process the queue:
                 - For each character, append it to the result.
                 - Decrease `in_degree` of its neighbors.
                 - If any neighbor’s `in_degree` becomes 0, add it to the queue.

            4. **Final Check**:
               - If the result contains all unique characters, return the result.
               - Otherwise, a cycle or invalid order exists → return `""`.

            Time Complexity:  O(N * L)
                - N = number of words, L = average word length

            Space Complexity: O(V + E)
                - V = number of unique characters, E = number of edges in the graph
    */


    public static String alienOrder(String[] words) {
        if(words.length == 0) {
            return "";
        }

        // Step 1. construct the graph and initiate the in degree
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> in_degree = new HashMap<>();

        for(String word : words) {
            for(char ch : word.toCharArray()) {
                graph.putIfAbsent(ch, new ArrayList<>());
                in_degree.putIfAbsent(ch, 0);
            }
        }

        for(int i=1; i<words.length; i++) {
            String prevWord = words[i-1];
            String currWord = words[i];

            boolean isDifference = false;

            for(int j=0; j<Math.min(prevWord.length(), currWord.length()); j++) {
                if(prevWord.charAt(j) != currWord.charAt(j)) {
                    isDifference = true;
                    graph.get(prevWord.charAt(j)).add(currWord.charAt(j));
                    int new_degree = in_degree.get(currWord.charAt(j)) + 1;
                    in_degree.put(currWord.charAt(j), new_degree);
                    break;
                }
            }

            if(!isDifference && prevWord.length() > currWord.length()) {
                return "";
            }
        }

        Queue<Character> queue = new ArrayDeque<>();

        for(Map.Entry<Character, Integer> en : in_degree.entrySet()) {
            char ch = en.getKey();
            int in_degree_val = en.getValue();
            if(in_degree_val == 0) {
                queue.offer(ch);
            }
        }

        StringBuilder alienOrder = new StringBuilder();

        while(!queue.isEmpty()) {
            char currCh = queue.poll();
            alienOrder.append(currCh);

            for(char nextCh : graph.get(currCh)) {
                in_degree.put(nextCh, in_degree.get(nextCh)-1);

                if(in_degree.get(nextCh) == 0) {
                    queue.offer(nextCh);
                }
            }
        }

        if(alienOrder.length() != in_degree.size()) {
            return "";
        }
        return alienOrder.toString();
    }


    public static void main(String[] args) {
        System.out.println(alienOrder(new String[]{"wrt","wrf","er","ett","rftt"}));
    }
}
