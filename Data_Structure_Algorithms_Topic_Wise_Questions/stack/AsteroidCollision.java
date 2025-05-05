package Data_Structure_Algorithms_Topic_Wise_Questions.stack;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {

    public static boolean isDifferentAsteroids(int current, int prev) {
        return (current < 0 && prev > 0);
    }

    public static int[] asteroidCollision(int[] asteroids) {
        if(asteroids.length < 2) {
            return asteroids;
        }

        Stack<Integer> stack = new Stack<>();

        for(int asteroid : asteroids) {
           boolean isDestroyed = false;
           while(!stack.isEmpty() && isDifferentAsteroids(asteroid, stack.peek())) {
               int prevAsteroid = stack.peek();

               if(Math.abs(asteroid) > Math.abs(prevAsteroid)) {
                   stack.pop();
               }else if(Math.abs(asteroid) == Math.abs(prevAsteroid)) {
                   stack.pop();
                   isDestroyed = true;
               }else {
                   isDestroyed = true;
                   break;
               }
           }

           if(!isDestroyed) {
               stack.push(asteroid);
           }

        }

        int[] ans = new int[stack.size()];
        int idx = stack.size()-1;

        while(!stack.isEmpty()) {
            ans[idx--] = stack.pop();
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[]{-2,-1,1,2})));
    }
}
