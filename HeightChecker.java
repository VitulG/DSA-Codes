import java.util.Arrays;

public class HeightChecker {

    public static int heightChecker(int[] heights) {
        int[] expected = new int[heights.length];
        int idx = -1;

        for(int height : heights) {
            expected[++idx] = height;
        }

        Arrays.sort(expected);

        int heightMismatch = 0;

        for(int i=0; i<heights.length; i++) {
            if(heights[i] != expected[i]) {
                heightMismatch += 1;
            }
        }

        return heightMismatch;

    }

    public static void main(String[] args) {
        System.out.println(heightChecker(new int[]{1,2,3,4,5}));
    }
}
