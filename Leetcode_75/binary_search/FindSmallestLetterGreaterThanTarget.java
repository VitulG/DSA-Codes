package Leetcode_75.binary_search;

public class FindSmallestLetterGreaterThanTarget {

    public static char nextGreatestLetter(char[] letters, char target) {
        int lo = 0;
        int hi = letters.length-1;

        int targetValue = target-'0';

        char nextGreaterLetter = '~';

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            int charValue = letters[mid] - '0';

            if(charValue <= targetValue) {
                lo = mid + 1;
            }else {
                nextGreaterLetter = letters[mid];
                hi = mid - 1;
            }
        }
        return nextGreaterLetter == '~' ? letters[0] : nextGreaterLetter;

    }

    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char[]{'c','f','j'}, 'l'));
    }
}
