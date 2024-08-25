import java.util.Arrays;

public class BoatsToSavePeople {

    public static int numRescueBoats(int[] people, int limit) {
        if(people.length == 0) {
            return 0;
        }

        Arrays.sort(people);
        int boats = 0;

        int lo = 0;
        int hi = people.length-1;

        while(lo <= hi) {
            boats+=1;
            if(people[lo] + people[hi] <= limit) {
                lo++;
                hi--;
            }else{
                hi--;
            }
        }
        return boats;

    }

    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[]{3,5,3,4}, 5));
    }
}