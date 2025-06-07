import java.util.*;

public class LexicographicallyMinimumStringAfterRemovingStars {

    static class Pair {
        char ch;
        int idx;

        public Pair(char ch, int idx) {
            this.ch = ch;
            this.idx = idx;
        }
    }

    public static String clearStars(String str) {
        if(str.isEmpty()) {
            return "";
        }

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b) ->  (a.ch == b.ch) ? (b.idx - a.idx) : (a.ch - b.ch));
        List<Character> chars = new ArrayList<>();

        for(char ch : str.toCharArray()) {
            if(ch != '*') {
                chars.add(ch);
                minHeap.offer(new Pair(ch, chars.size()-1));
            }else {
                while(!minHeap.isEmpty()) {
                    Pair minChar = minHeap.poll();
                    if(chars.get(minChar.idx) != '~') {
                        chars.set(minChar.idx, '~');
                        break;
                    }
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        for(char ch : chars) {
            if(ch != '~') {
                ans.append(ch);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(clearStars("aaba*"));
    }
}
