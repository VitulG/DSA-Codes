package Data_Structure_Algorithms_Topic_Wise_Questions.prefix_sum;

public class FindTheHighestAltitude {

    public static int largestAltitude(int[] gain) {
        int[] altitudes = new int[gain.length];
        altitudes[0] = gain[0];

        int largestAltitude = Math.max(0, gain[0]);

        for(int i=1; i<gain.length; i++) {
            altitudes[i] = altitudes[i-1] + gain[i];
            largestAltitude = Math.max(altitudes[i], largestAltitude);
        }
        return largestAltitude;
    }

    public static void main(String[] args) {
        System.out.println(largestAltitude(new int[]{-4,-3,-2,-1,4,3,2}));
    }
}
