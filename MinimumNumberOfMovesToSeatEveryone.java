import java.util.Arrays;

public class MinimumNumberOfMovesToSeatEveryone {

    public static int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);

        int minMoves = 0;

        for(int i=0; i<students.length; i++) {
            minMoves += Math.abs(seats[i] - students[i]);
        }
        return minMoves;
    }
    
    public static void main(String[] args) {
        System.out.println(minMovesToSeat(new int[]{4,1,5,9}, new int[]{1,3,2,6}));
    }
}
