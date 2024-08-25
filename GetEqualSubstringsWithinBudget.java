public class GetEqualSubstringsWithinBudget {

    public static int equalSubstring(String src, String tar, int maxCost) {
        int size = src.length();
        int i = 0;
        int j = 0;
        int currCost = 0;
        int maxLen = Integer.MIN_VALUE;

        while(j < size) {
            currCost += Math.abs(src.charAt(j) - tar.charAt(j));

            while(currCost > maxCost) {
                currCost -= Math.abs(src.charAt(i) - tar.charAt(i));
                i++;
            }
            maxLen = Math.max(maxLen, j-i+1);
            j++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(equalSubstring("pxezla", "loewbi", 25));
    }
    
}
