public class TrappingRainWater{
    public static int trap(int[] heights) {
        
        // calculate max heights from left
        int[] leftMaxHeights = new int[heights.length];
        leftMaxHeights[0] = heights[0];

        for(int i=1; i<heights.length; i++) {
            leftMaxHeights[i] = Math.max(heights[i], leftMaxHeights[i-1]);
        }

        // calculate max heights from right
        int[] rightMaxHeights = new int[heights.length];
        rightMaxHeights[rightMaxHeights.length-1] = heights[heights.length-1];
        for(int i=heights.length-2; i>=0; i--){
            rightMaxHeights[i] = Math.max(heights[i], rightMaxHeights[i+1]);
        }


        // now calculate the water trapped inside a container
        int maxWaterTrapped = 0;
        for(int i=0; i<heights.length; i++) {
            maxWaterTrapped += Math.min(leftMaxHeights[i], rightMaxHeights[i])-heights[i];
        }
        return maxWaterTrapped;

    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}