public class MinimumArrayEnd {

    public static long minEnd(int n, int x) {
        long currNum = x;

        for(int i=1; i<n; i++) {
            currNum = (currNum+1) | x;
        }
        return currNum;
    }

    public static void main(String[] args) {
        System.out.println(minEnd(3,4));
    }
}
