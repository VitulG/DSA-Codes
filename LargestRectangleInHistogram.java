import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {

    public static int[] getLeftSmallerElements(int[] heights) {

        Stack<Integer> stack = new Stack<Integer>();

        int[] leftSmallerIndices = new int[heights.length];
        Arrays.fill(leftSmallerIndices, -1);

        for(int i=0; i<heights.length; i++) {
            int currElement = heights[i];

            while(!stack.isEmpty() && currElement <= heights[stack.peek()]) {
                stack.pop();
            }

            leftSmallerIndices[i] = (stack.isEmpty()) ? -1 : stack.peek();
            stack.push(i);
        }
        return leftSmallerIndices;

    }

    public static int[] getRightSmallerElements(int[] heights) {

        Stack<Integer> stack = new Stack<Integer>();
        
        int[] rightSmallerIndices = new int[heights.length];
        Arrays.fill(rightSmallerIndices, heights.length);

        for(int i=heights.length-1; i>=0; i--) {
            int currElement = heights[i];

            while(!stack.isEmpty() && currElement <= heights[stack.peek()]) {
                stack.pop();
            }

            rightSmallerIndices[i] = (stack.isEmpty()) ? heights.length : stack.peek();
            stack.push(i);
        }
        return rightSmallerIndices;
    }

    public static int largestRectangleArea(int[] heights) {
        if(heights.length == 1) {
            return heights[0];
        }

        int[] leftSmaller = getLeftSmallerElements(heights);
        int[] rightSmaller = getRightSmallerElements(heights);

        int maxArea = Integer.MIN_VALUE;
        int len = heights.length;

        for(int i=0; i<len; i++) {
            maxArea = Math.max(maxArea, heights[i] * (rightSmaller[i]-leftSmaller[i]-1));
        }
        return maxArea;

    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{0,9}));
    }
}