import java.util.Arrays;
import java.util.Stack;

public class MaximalRectangle {

    public static int[] getLeftSmaller(int[] arr) {
        int[] leftSmaller = new int[arr.length];
        Arrays.fill(leftSmaller, -1);

        Stack<Integer> stack = new Stack<Integer>();

        for(int i=0; i<arr.length; i++) {
            int currElement = arr[i];

            while(!stack.isEmpty() && currElement <= arr[stack.peek()]) {
                stack.pop();
            }

            leftSmaller[i] = (stack.isEmpty()) ? -1 : stack.peek();
            stack.push(i);

        }
        return leftSmaller;

    } 

    public static int[] getRightSmaller(int[] arr) {
        int[] rightSmaller = new int[arr.length];
        Arrays.fill(rightSmaller, arr.length);

        Stack<Integer> stack = new Stack<Integer>();

        for(int i=arr.length-1; i>=0; i--) {
            int currElement = arr[i];

            while(!stack.isEmpty() && currElement <= arr[stack.peek()]) {
                stack.pop();
            }

            rightSmaller[i] = (stack.isEmpty()) ? arr.length : stack.peek();
            stack.push(i);

        }
        return rightSmaller;

    }

    public static int largestRectangle(int[] histogram) {

        int[] leftSmaller = getLeftSmaller(histogram);
        int[] rightSmaller = getRightSmaller(histogram);

        int currRectangleMax = Integer.MIN_VALUE;

        for(int i=0; i<histogram.length; i++) {
            int len = histogram[i];
            int bre = rightSmaller[i] - leftSmaller[i]-1;

            currRectangleMax = Math.max(currRectangleMax, len * bre);

        }
        return currRectangleMax;

    }

    public static int maximalRectangle(char[][] matrix) {
        int[] histogram = new int[matrix[0].length];
        Arrays.fill(histogram, 0);

        int maxiRectangle = Integer.MIN_VALUE;

        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                histogram[j] = (matrix[i][j] == '1') ? histogram[j]+1 : 0;
            }
            maxiRectangle = Math.max(maxiRectangle, largestRectangle(histogram));
        }
        return maxiRectangle;
    }


    public static void main(String[] args) {
        System.out.println(maximalRectangle(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));
    }
    
}
