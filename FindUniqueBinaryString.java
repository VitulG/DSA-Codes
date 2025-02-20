import java.util.*;

public class FindUniqueBinaryString {

    public static void generateUniqueBinaryStrings(StringBuilder currString, int idx, int len, List<String> list) {
        if(idx >= len) {
            list.add(currString.toString());
            return;
        }

        for(char digit : "01".toCharArray()) {
            currString.append(digit);
            generateUniqueBinaryStrings(currString, idx+1, len, list);
            currString.deleteCharAt(currString.length()-1);
        }

    }

    public static String findDifferentBinaryString(String[] nums) {
        Set<String> uniqueStrings = new HashSet<>(Arrays.asList(nums));

        List<String> list = new ArrayList<>();

        generateUniqueBinaryStrings(new StringBuilder(), 0, nums[0].length(), list);

        for(String binaryString : list) {
            if(!uniqueStrings.contains(binaryString)) {
                return binaryString;
            }
        }
        return "";
    }


    public static void main(String[] args) {
        System.out.println(findDifferentBinaryString(new String[]{"00","01"}));
    }

}
