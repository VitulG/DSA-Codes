import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioningI {

    public static boolean isPalindrome(String str, int currIdx, int endIdx) {
        while(currIdx < endIdx) {
            if(str.charAt(currIdx++) != str.charAt(endIdx--)) {
                return false;
            }
        }
        return true;
    }

    public static void processPalindromic(String str, int idx, List<List<String>> palindromicList, List<String> currList) {
        if(idx >= str.length()){
            palindromicList.add(new ArrayList<String>(currList));
            return;
        }

        for(int i = idx; i < str.length(); i++) {
            if(isPalindrome(str, idx, i)) {
                currList.add(str.substring(idx, i+1));
                processPalindromic(str, i+1, palindromicList, currList);
                currList.remove(currList.size() -1);
            }
        }
    }

    public static List<List<String>> partition(String str) {
        if(str.isEmpty() || str == null || str.isBlank()) {
            return new ArrayList<List<String>>();
        }

        List<List<String>> palindromicList = new ArrayList<List<String>>();
        processPalindromic(str, 0, palindromicList, new ArrayList<>());
        return palindromicList;

    }


    public static void main(String[] args) {
        System.out.println(partition(""));
    }
}
