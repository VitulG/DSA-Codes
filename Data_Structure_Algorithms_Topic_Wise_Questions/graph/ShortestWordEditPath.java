package Data_Structure_Algorithms_Topic_Wise_Questions.graph;

import java.util.*;

public class ShortestWordEditPath {

    public static int shortestWordEditPath(String source, String target, String[] words) {
        if(source.equals(target)) {
            return 0;
        }

        Set<String> availableWords = new HashSet<>(Arrays.asList(words));

        if(!availableWords.contains(target)) {
            return -1;
        }

        Set<String> isVisited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();

        queue.offer(source);
        isVisited.add(source);

        int level = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();

            while(size-- > 0) {
                String current = queue.poll();

                if(current.equals(target)) {
                    return level;
                }

                for(int i=0; i<current.length(); i++) {
                    StringBuilder str = new StringBuilder(current);
                    for(char ch : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
                        str.setCharAt(i, ch);

                        if(availableWords.contains(str.toString()) && !isVisited.contains(str.toString())) {
                            queue.offer(str.toString());
                            isVisited.add(str.toString());
                        }

                    }
                }
            }

            level++;
        }
        return -1;
    }

    public static void main(String[] args) {

        System.out.println(shortestWordEditPath("bit","dog", new String[]{
                "but", "put", "big", "pot", "pog", "dog", "lot"
        }));
    }
}
