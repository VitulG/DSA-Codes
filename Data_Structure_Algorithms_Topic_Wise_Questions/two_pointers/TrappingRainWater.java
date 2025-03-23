package Data_Structure_Algorithms_Topic_Wise_Questions.two_pointers;

public class TrappingRainWater {

    public static int trap(int[] heights) {
        int[] leftMaxHeight = new int[heights.length];
        leftMaxHeight[0] = heights[0];

        for(int i=1; i<heights.length; i++) {
            leftMaxHeight[i] = Math.max(leftMaxHeight[i-1], heights[i]);
        }

        int[] rightMaxHeight = new int[heights.length];
        rightMaxHeight[heights.length-1] = heights[heights.length-1];

        for(int i=heights.length-2; i>=0; i--) {
            rightMaxHeight[i] = Math.max(rightMaxHeight[i+1], heights[i]);
        }

        int totalWaterTrapped = 0;

        for(int i=0; i<heights.length; i++) {
            totalWaterTrapped += (Math.min(leftMaxHeight[i], rightMaxHeight[i]) - heights[i]);
        }
        return totalWaterTrapped;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{4,2,0,3,2,5}));
    }
}
