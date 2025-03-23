package Data_Structure_Algorithms_Topic_Wise_Questions.two_pointers;

import java.util.Arrays;

public class BoatsToSavePeople {

    public static int numRescueBoats(int[] peoples, int limit) {
        if(peoples.length == 0) {
            return 0;
        }

        Arrays.sort(peoples);
        int lo = 0;
        int hi = peoples.length-1;

        int boats = 0;

        while(lo <= hi) {
            if(peoples[lo] + peoples[hi] <= limit) {
                lo++;
            }
            boats++;
            hi--;
        }
        return boats;
    }

    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[]{3,5,3,4}, 5));
    }
}
