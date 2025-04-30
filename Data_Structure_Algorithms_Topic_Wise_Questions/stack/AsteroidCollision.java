package Data_Structure_Algorithms_Topic_Wise_Questions.stack;

import java.util.Arrays;

public class AsteroidCollision {

    public static int[] asteroidCollision(int[] asteroids) {
        if(asteroids.length < 2) {
            return asteroids;
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[]{-2,-2,1,-2})));
    }
}
