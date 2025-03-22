package Data_Structure_Algorithms_Topic_Wise_Questions.two_pointers;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {

        if(height.length < 2) {
            return 0;
        }

        int le = 0;
        int ri = height.length-1;

        int maxArea = 0;

        while(le < ri) {
            int currentArea = (ri - le) * (Math.min(height[le], height[ri]));
            maxArea = Math.max(maxArea, currentArea);

            if(height[le] < height[ri]) {
                le++;
            }else {
                ri--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
