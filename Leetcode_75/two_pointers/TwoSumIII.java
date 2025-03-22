package Leetcode_75.two_pointers;

import java.util.Map;
import java.util.HashMap;

class TwoSum {
    private Map<Integer, Integer> map;

    public TwoSum() {
        this.map = new HashMap<>();
    }

    public void add(int num) {
        this.map.put(num, map.getOrDefault(num, 0) + 1);
    }

    public boolean find(int value) {
        for(int num : this.map.keySet()) {
            int pairNum = value - num;
            if(this.map.containsKey(pairNum)) {
                if(num == pairNum && this.map.get(pairNum) > 1) {
                    return true;
                }

                if(num != pairNum) {
                    return true;
                }
            }
        }
        return false;
    }
}

public class TwoSumIII {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        twoSum.add(3);
        twoSum.add(2);
        twoSum.add(5);
        System.out.println(twoSum.find(4));
        System.out.println(twoSum.find(7));
        System.out.println(twoSum.find(6));
        twoSum.add(3);
        System.out.println(twoSum.find(6));

    }
}
