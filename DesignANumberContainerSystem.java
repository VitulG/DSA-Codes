import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class NumberContainers {
    private Map<Integer, TreeSet<Integer>> numberToIndices;
    private Map<Integer, Integer> numberToIndex;

    public NumberContainers() {
        this.numberToIndices = new HashMap<>();
        this.numberToIndex = new HashMap<>();
    }

    public void change(int index, int number) {
        if(numberToIndex.containsKey(index)) {
            int prevNumber = numberToIndex.get(index);

            if(prevNumber == number) {
                return;
            }

            TreeSet<Integer> prevSet = numberToIndices.get(prevNumber);
            prevSet.remove(index);

            if(prevSet.isEmpty()) {
                numberToIndices.remove(prevNumber);
            }
        }
        numberToIndex.put(index, number);

        numberToIndices.putIfAbsent(number, new TreeSet<>());
        numberToIndices.get(number).add(index);
    }

    public int find(int number) {
        if(!numberToIndices.containsKey(number) || numberToIndices.get(number).isEmpty()) {
            return -1;
        }
        return numberToIndices.get(number).first();
    }
}

public class DesignANumberContainerSystem {

    public static void main(String[] args) {
        NumberContainers numberContainers = new NumberContainers();
        System.out.println(numberContainers.find(10));
        numberContainers.change(2,10);
        numberContainers.change(1,10);
        numberContainers.change(3,10);
        numberContainers.change(5,10);
        System.out.println(numberContainers.find(10));
        numberContainers.change(1,20);
        System.out.println(numberContainers.find(10));
    }
}
