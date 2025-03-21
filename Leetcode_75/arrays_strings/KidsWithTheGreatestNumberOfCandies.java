package Leetcode_75.arrays_strings;

import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = Integer.MIN_VALUE;

        for(int candy : candies) {
            maxCandies = Math.max(candy, maxCandies);
        }

        List<Boolean> hasGreaterCandies = new ArrayList<>();

        for(int candy : candies) {
            hasGreaterCandies.add(candy+extraCandies >= maxCandies);
        }

        return hasGreaterCandies;
    }

    public static void main(String[] args) {
        System.out.println(kidsWithCandies(new int[]{2,3,5,1,3}, 3));
    }
}
