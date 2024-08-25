import java.util.List;

public class MaximumDistanceInArrays {

    //8218245867 => Rahul Battery
    
    public static int maxDistance(List<List<Integer>> arrays) {
        if(arrays.size() == 0){
            return 0;
        }

        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);

        int difference = 0;

        for(int i=1; i<arrays.size(); i++) {
            int currMin = arrays.get(i).get(0);
            int currMax = arrays.get(i).get(arrays.get(i).size() - 1);

            difference = Math.max(difference, Math.abs(currMax - min));
            difference = Math.max(difference, Math.abs(currMin-max));

            min = Math.min(min, currMin);
            max = Math.max(max, currMax);
        }
        return difference;
        
    }
    public static void main(String[] args) {
        List<Integer> list1 = List.of(1,2,3);
        List<Integer> list2 = List.of(4,5);
        List<Integer> list3 = List.of(1,2,3);

        List<List<Integer>> list = List.of(list1,list2,list3);
        System.out.println(maxDistance(list));
    }
}
