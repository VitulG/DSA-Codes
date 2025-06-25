package Data_Structure_Algorithms_Topic_Wise_Questions.heaps;

import java.util.*;

public class TopKFrequentElements {

    /*
        Approach: - We will use a map for storing elements with their number along with their frequencies.
                    and a min heap for to get higher frequency numbers first or largest number first in case
                    if the frequencies of two numbers are same. Just add in the heap and get the top k most
                    frequent elements;

                    TC -> O(n log n)
                    SC -> O(n)
     */

    static class Element {
        int number;
        int frequency;

        public Element(int number, int frequency) {
            this.number = number;
            this.frequency =frequency;
        }
    }

    static class SortElements implements Comparator<Element> {

        @Override
        public int compare(Element e1, Element e2) {
            if(e1.frequency == e2.frequency) {
                return e2.number - e1.number;
            }
            return e2.frequency - e1.frequency;
        }
    }

    public static ArrayList<Integer> topKFrequent(int[] arr, int k) {
        if(arr.length == 0 || arr.length < k) {
            return new ArrayList<>();
        }

        Map<Integer, Integer> map = new HashMap<>();

        for(int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Element> queue = new PriorityQueue<>(new SortElements());

        for(Map.Entry<Integer, Integer> en : map.entrySet()) {
            int number = en.getKey();
            int frequency = en.getValue();
            queue.offer(new Element(number, frequency));
        }

        ArrayList<Integer> topKFrequentNumbers = new ArrayList<>();

        while(!queue.isEmpty() && k-- > 0) {
            topKFrequentNumbers.add(queue.poll().number);
        }
        return topKFrequentNumbers;
    }

    public static void main(String[] args) {
        System.out.println(topKFrequent(new int[]{3, 1, 4, 4, 5, 2, 6, 1}, 2));
    }
}
