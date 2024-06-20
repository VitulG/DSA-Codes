import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {

    public static boolean isPossibleToPlace(int[] positions, int pos, int m) {
        int count = 1;
        int prev = positions[0];

        for(int i=0; i<positions.length; i++) {
            if(Math.abs(positions[i] - prev) >= pos) {
                count++;
                prev = positions[i];
            }

            if(count == m) {
                return true;
            }
        }
        return false;
    }

    public static int maxDistance(int[] positions, int m) {
        Arrays.sort(positions);

        int left = 1;
        int right = Integer.MIN_VALUE;

        for(int position : positions) {
            right = Math.max(right, position);
        }

        int ans = -1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(isPossibleToPlace(positions, mid, m)) {
                ans = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(maxDistance(new int[]{5,4,3,2,1,1000000000}, 2));
    }
}