public class CountVowelStringsInRanges {

    public static boolean isCharVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public static int[] vowelStrings(String[] words, int[][] queries) {
        int[] vowelWordCount = new int[words.length];
        vowelWordCount[0] = (isCharVowel(words[0].charAt(0)) &&
                isCharVowel(words[0].charAt(words[0].length()-1))) ? 1 : 0;

        for(int i = 1; i<words.length; i++) {
            if(isCharVowel(words[i].charAt(0)) &&
                    isCharVowel(words[i].charAt(words[i].length()-1))) {
                vowelWordCount[i] = vowelWordCount[i-1] + 1;
            } else {
                vowelWordCount[i] = vowelWordCount[i-1];
            }
        }

        int[] ans = new int[queries.length];
        int idx = 0;

        for(int[] query : queries) {
            if(query[0] == 0) {
                ans[idx++] = vowelWordCount[query[1]];
            }else {
                ans[idx++] = vowelWordCount[query[1]] - vowelWordCount[query[0] -1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] result = vowelStrings(new String[]{"aba","bcb","ece","aa","e"},
                new int[][]{
                        {0,2},
                        {1,4},
                        {1,1}
                });

        for(int num : result) {
            System.out.print(num+" ");
        }
    }
}
