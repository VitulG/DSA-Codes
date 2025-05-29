package Data_Structure_Algorithms_Topic_Wise_Questions.graph;

import java.util.*;

public class WordLadder {

    /*
        Approach: - to Solve this question, we will use queue for bfs
                    why? -> because we need the shortest transformations, so every time we can proceed with a word
                                to change at ith character with character 26 and so on
                    1. Use queue for BFS.
                    2. start with beginning word and put that word into the queue.
                    3. process each character with the current string with the new character i.e 1 to 26 chars
                    4. if that newly created string is not processed, and the dictionary has that word, so we can
                         put that string into our queue and so on.
                    5. if we reach to the end word then return words+1 level or else return 0 we will never reach to the
                         end word.

                    TC -> O(N * L)
                    SC -> O(N * L)
     */

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dictionary = new HashSet<>(wordList);

        if(!dictionary.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);

        Set<String> isVisited = new HashSet<>();
        isVisited.add(beginWord);

        int words = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                String currentTransformation = queue.poll();

                if(currentTransformation.equals(endWord)) {
                    return words + 1;
                }

                for(int i=0; i<currentTransformation.length(); i++) {
                    StringBuilder newTransformation = new StringBuilder(currentTransformation);
                    for(char ch : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
                        newTransformation.setCharAt(i, ch);

                        if(dictionary.contains(newTransformation.toString()) &&
                                !isVisited.contains(newTransformation.toString())) {
                            queue.offer(newTransformation.toString());
                            isVisited.add(newTransformation.toString());
                        }

                    }
                }
            }
            words++;
        }
        return 0;
    }

    public static void main(String[] args) {
        List<String> wordList = List.of("hot","dot","dog","lot","log","cog");
        System.out.println(ladderLength("hit", "cog", wordList));
    }
}
