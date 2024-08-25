import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class RobotCollisions {
    static class Robot {
        int position;
        int health;
        char direction;
        int originalPosition;

        public Robot(int position, int health, char direction, int originalPosition) {
            this.direction = direction;
            this.health = health;
            this.position = position;
            this.originalPosition = originalPosition;
        }
    }

    static class SortRobots implements Comparator<Robot> {

        @Override
        public int compare(Robot r1, Robot r2) {
            return r1.position - r2.position;
        }
        
    }


    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        
        int size = positions.length;

        Robot[] robots = new Robot[size];

        for(int i=0; i<size; i++) {
            robots[i] = new Robot(positions[i], healths[i], directions.charAt(i), i);
        }

        Arrays.sort(robots, new SortRobots());

        Stack<Robot> stack = new Stack<Robot>();

        for(int i=0; i<size; i++) {
            Robot robot = robots[i];

            while(!stack.isEmpty() && robot.direction == 'L' && stack.peek().direction == 'R') {
                Robot prev = stack.pop();

                if(robot.health == prev.health) {
                    robot = null;
                    break;
                }else if(robot.health > prev.health) {
                    robot.health -= 1;
                    continue;
                }else {
                    prev.health -= 1;
                    stack.push(prev);
                    robot = null;
                    break;    
                }
            }

            if(robot != null) {
                stack.push(robot);
            }
        }

        List<Robot> survivors = new ArrayList<Robot>(stack);
        survivors.sort(Comparator.comparingInt(r -> r.originalPosition));

        List<Integer> ans = new ArrayList<Integer>();
        
        for(Robot robot : survivors) {
            ans.add(robot.health);
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(survivedRobotsHealths(new int[]{1,2,5,6}, new int[]{10,10,11,11}, "RLRL"));
    }
    
}
