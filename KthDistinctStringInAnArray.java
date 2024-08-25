import java.util.PriorityQueue;

public class KthDistinctStringInAnArray {

    static class Pair {
        String str;
        int idx;

        public Pair(String str, int idx) {
            this.str = str;
            this.idx = idx;
        }
    }

    public static String kthDistinct(String[] arr, int k) {
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>((a,b) -> a.idx - b.idx);

        for(int i=0; i<arr.length; i++) {
            String curr = arr[i];
            int j=0;
            for(;j<arr.length; j++) {
                if(i != j && arr[j].equals(curr)) {
                    break;
                }
            }
            if(j == arr.length) {
                queue.add(new Pair(curr, i));
            }
        }

        if(queue.isEmpty() || queue.size() < k) {
            return "";
        }

        StringBuilder ans = new StringBuilder("");

        while(k-- > 0) {
            String str = queue.poll().str;
            if(k == 0) {
                ans.append(str);
            }
        }
        return ans.toString();

    }

    public static void main(String[] args) {
        System.out.println(kthDistinct(new String[]{"a","b","a"}, 3));
    }
}