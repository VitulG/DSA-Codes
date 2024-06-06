import java.util.TreeMap;

public class HandOfStraights {

    public static boolean isNStraightHand(int[] hand, int groupSize) {
        int size = hand.length;

        if(size%groupSize != 0) {
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

        for(int i=0; i<size; i++) {
            int value = hand[i];
            map.put(value, map.getOrDefault(value, 0) +1);
        }

        while(!map.isEmpty()) {
            int first = map.firstKey();

            for(int i=0; i<groupSize; i++) {
                int nextKey = first + i;

                if(!map.containsKey(nextKey)) {
                    return false;
                }

                int value = map.get(nextKey);

                if(value == 1) {
                    map.remove(nextKey);
                }else{
                    map.put(nextKey, value-1);
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isNStraightHand(new int[]{1,2,3,4,5}, 4));
    }
}
