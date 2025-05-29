package Data_Structure_Algorithms_Topic_Wise_Questions.graph;

import java.util.*;

public class WordLadderII {

    /*
        Approach: - This problem is an extension of Word Ladder 1.
                    We need to find **all shortest transformation sequences**.

            1. Use **BFS** to build a map where each word is associated with the minimum number of steps (level) it took
               to reach that word from the `beginWord`.

            2. Once BFS is done and we have reached the `endWord`, we know the shortest path length.

            3. Now, use **DFS/backtracking** to build all sequences from `endWord` to `beginWord`.
                a. At each step in DFS, we move to a word that is one level earlier (i.e., level[word] < level[current]).
                b. This ensures we only include words from the shortest transformation path.

            4. When we reach the `beginWord`, we reverse the current sequence (since we built it backward) and add to the result.

            Time Complexity:
                TC -> O(n * l + k), where:
                      n = number of words in wordList
                      l = word length
                      k = total number of nodes visited in DFS (bounded due to level filtering)

            Space Complexity:
                SC -> O(n * l) for the level map and visited sets
                      + O(k) for DFS recursion and answer storage
    */


    public static void dfs(String end, String start, List<String> currentSequence, List<List<String>> sequences,
                           Map<String, Integer> map) {
        if(end.equals(start)) {
            if(!currentSequence.isEmpty()) {
                Collections.reverse(currentSequence);
                sequences.add(new ArrayList<>(currentSequence));
                Collections.reverse(currentSequence);
            }
            return;
        }

        for(int i=0; i<end.length(); i++) {
            StringBuilder prevTransformation = new StringBuilder(end);
            for(char ch : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
                prevTransformation.setCharAt(i, ch);

                if(map.containsKey(prevTransformation.toString()) && map.get(prevTransformation.toString()) < map.get(end)) {
                    currentSequence.add(prevTransformation.toString());
                    dfs(prevTransformation.toString(), start, currentSequence, sequences, map);
                    currentSequence.remove(currentSequence.size()-1);
                }
            }
        }
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dictionary = new HashSet<>(wordList);

        if(dictionary.isEmpty() || !dictionary.contains(endWord)) {
            return new ArrayList<>();
        }

        // step 1. move forward to end word via BFS and track word and level using map
        Map<String, Integer> map = new HashMap<>();
        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        queue.offer(beginWord);
        map.put(beginWord, 1);
        visited.add(beginWord);

        int level = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();

            while(size-- > 0) {
                String currentTransformation = queue.poll();

                if(currentTransformation.equals(endWord)) {
                    break;
                }

                for(int i=0; i<currentTransformation.length(); i++) {
                    StringBuilder newTransformation = new StringBuilder(currentTransformation);
                    for(char ch : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
                        newTransformation.setCharAt(i, ch);
                        if(dictionary.contains(newTransformation.toString()) &&
                                !visited.contains(newTransformation.toString())) {
                            map.put(newTransformation.toString(), level+1);
                            queue.offer(newTransformation.toString());
                            visited.add(newTransformation.toString());
                        }
                    }
                }
            }
            level++;
        }

        // step 2. start from the end make every sequence from the begin to end word using Backtracking

        List<List<String>> sequences = new ArrayList<>();

        if(map.containsKey(endWord)) {
            List<String> currentSequence = new ArrayList<>();
            currentSequence.add(endWord);
            dfs(endWord, beginWord, currentSequence, sequences, map);
        }
        return sequences;
    }

    public static void main(String[] args) {
        List<String> wordList = List.of("hot","dot","dog","lot","log","cog");
        System.out.println(findLadders("hit", "cog", wordList));
    }
}
