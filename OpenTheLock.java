import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenTheLock {

    public static void fillNbrs(Queue<String> queue, StringBuilder currSb, Set<String> set) {
        for(int i=0; i<4; i++) {
            char currChar = currSb.charAt(i);

            char next = (currChar == '9') ? '0' : (char) (currChar + 1);
            char prev = (currChar == '0') ? '9' : (char) (currChar - 1);

            currSb.setCharAt(i, next);
            if(!set.contains(currSb.toString())) {
                queue.offer(currSb.toString());
                set.add(currSb.toString());
            }

            currSb.setCharAt(i, prev);
            if(!set.contains(currSb.toString())) {
                queue.offer(currSb.toString());
                set.add(currSb.toString());
            }

            currSb.setCharAt(i, currChar);

        }
    }

    public static int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<String>();

        for(String deadend : deadends) {
            set.add(deadend);
        }

        String start = "0000";

        if(set.contains(start)) {
            return -1;
        }

        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);

        int level = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();

            while(size-- > 0) {
                String curr = queue.poll();
                if(curr.equals(target)) {
                    return level;
                }
                StringBuilder currSb = new StringBuilder(curr);
                fillNbrs(queue, currSb, set);

            }
            level++;
        }
        return -1;

    }

    public static void main(String[] args) {
        System.out.println(openLock(new String[]{"8888"}, "0009"));
    }
}