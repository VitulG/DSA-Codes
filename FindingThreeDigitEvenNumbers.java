import java.util.*;

public class FindingThreeDigitEvenNumbers {

    public static int[] findEvenNumbers(int[] digits) {
        if(digits.length == 0) {
            return new int[]{};
        }

        Set<Integer> uniqueNumbers = new HashSet<>();

        for(int i=0; i<digits.length; i++) {
            for(int j=0; j< digits.length; j++) {
                for(int k=0; k<digits.length; k++) {
                    if(i == j || j == k || k == i) {
                        continue;
                    }
                    int number = digits[i] * 100 + digits[j] * 10 + digits[k];

                    if(number >= 100 && number%2 == 0) {
                        uniqueNumbers.add(number);
                    }
                }
            }
        }

        List<Integer> evenNumbers = new ArrayList<>(uniqueNumbers);
        Collections.sort(evenNumbers);
        int[] ans = new int[evenNumbers.size()];

        for(int i =0; i< evenNumbers.size(); i++) {
            ans[i] = evenNumbers.get(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findEvenNumbers(new int[]{2,1,3,0})));
    }
}
