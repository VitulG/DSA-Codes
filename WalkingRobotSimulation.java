import java.util.HashSet;
import java.util.Set;

public class WalkingRobotSimulation {

    static class Point {
        int x_axis;
        int y_axis;

        public Point(int x_axis, int y_axis) {
            this.x_axis = x_axis;
            this.y_axis = y_axis;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x_axis == point.x_axis && y_axis == point.y_axis;
        }

        @Override
        public int hashCode() {
            return 31 * x_axis + y_axis;
        }
    }

    public static int robotSim(int[] commands, int[][] obstacles) {
        Set<Point> obstaclePoints = new HashSet<>();
        for(int[] obstacle : obstacles) {
            obstaclePoints.add(new Point(obstacle[0], obstacle[1]));
        }

        Point origin = new Point(0,0);
        int maxEuclideanDistance = 0;

        // north = 0, east = 1, south = 2, west = 3
        int direction = 0;

        int[] yaxis = {1, 0, -1, 0};
        int[] xaxis = {0, 1, 0, -1};

        for(int command : commands) {
            if(command == -1) {
                // move right
                direction = (direction + 1) % 4;
            }else if(command == -2) {
                // move left
                direction = (direction + 3) % 4;
            }else {
                for(int i=0; i<command; i++) {
                    int newX = origin.x_axis + xaxis[direction];
                    int newY = origin.y_axis + yaxis[direction];

                    if(obstaclePoints.contains(new Point(newX, newY))) {
                        break;
                    }
                    origin.x_axis = newX;
                    origin.y_axis = newY;

                    maxEuclideanDistance = Math.max(maxEuclideanDistance, origin.x_axis * origin.x_axis +
                            origin.y_axis * origin.y_axis);
                }
            }
        }
        return maxEuclideanDistance;
    }

    public static void main(String[] args) {
        System.out.println(robotSim(new int[]{4,-1,3}, new int[][]{}));
    }
}
