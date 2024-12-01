import java.util.HashSet;
import java.util.Set;

public class CheckIfNAndItsDoubleExist {

    public static boolean checkIfExist(int[] arr) {
        Set<Integer> seen = new HashSet<>();

        for(int num : arr) {
            if(seen.contains(2*num) || (num%2==0 && seen.contains(num/2))) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkIfExist(new int[]{10,2,5,3}));
    }
}
