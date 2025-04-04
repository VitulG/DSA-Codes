package Data_Structure_Algorithms_Topic_Wise_Questions.backtracking;

public class LargestNumberInKSwaps {

    public static void swapChars(StringBuilder curr, int i, int j) {
        char ch = curr.charAt(i);
        curr.setCharAt(i, curr.charAt(j));
        curr.setCharAt(j, ch);
    }

    public static void generateMaximumNumber(StringBuilder curr, int k, String[] maxNum) {
        if(curr.toString().compareTo(maxNum[0]) > 0) {
            maxNum[0] = curr.toString();
        }

        if(k == 0) {
            return;
        }

        for(int i=0; i<curr.length()-1; i++) {
            for(int j=i+1; j<curr.length(); j++) {
                if(curr.charAt(i) < curr.charAt(j)) {
                    swapChars(curr, i, j);
                    generateMaximumNumber(curr, k-1, maxNum);
                    swapChars(curr, i, j);
                }
            }
        }
    }

    public static String findMaximumNum(String str, int k) {
        if(k == 0) {
            return str;
        }
        String[] maxNum = {""};
        generateMaximumNumber(new StringBuilder(str), k, maxNum);

        return maxNum[0];
    }

    public static void main(String[] args) {
        System.out.println(findMaximumNum("1034", 2));
    }
}
