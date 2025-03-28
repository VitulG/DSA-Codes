package Data_Structure_Algorithms_Topic_Wise_Questions.greedy;

import java.util.Arrays;
import java.util.List;

public class FractionalKnapsack {
    static class Item {
        int value;
        int weight;
        double valPerWt;

        public Item(int value, int weight, double valPerWt) {
            this.value = value;
            this.weight = weight;
            this.valPerWt =valPerWt;
        }
    }

    public static double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        Item[] items = new Item[val.size()];

        for(int i=0; i<val.size(); i++) {
            items[i] = new Item(val.get(i), wt.get(i), (double) val.get(i) / wt.get(i));
        }

        Arrays.sort(items, (a, b) -> Double.compare(b.valPerWt, a.valPerWt));

        double maxValue = 0.0d;

        for (Item item : items) {
            if (item.weight <= capacity) {
                maxValue += item.value;
                capacity -= item.weight;
            } else {
                maxValue += (item.valPerWt * capacity);
                break;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        List<Integer> val = List.of(60, 100, 120);
        List<Integer> wt = List.of(10, 20, 30);

        System.out.println(fractionalKnapsack(val, wt, 50));
    }
}
