public class FindTheLengthOfTheLongestCommonPrefix {
    private static TrieNode head;

    static class TrieNode {
        int val;
        boolean isDigitEnd;
        TrieNode[] children = new TrieNode[10];

        public TrieNode(int val) {
            this.val = val;
            this.isDigitEnd = false;
            for(int i=0; i<10; i++) {
                children[i] = null;
            }
        }
    }

    public static void insertInTrie(String word) {
        TrieNode curr = head;
        for(int i = 0; i<word.length(); i++) {
            int ch = word.charAt(i) - '0';

            if(curr.children[ch] == null) {
                curr.children[ch] = new TrieNode(ch);
            }
            curr = curr.children[ch];
        }
        curr.isDigitEnd = true;
    }

    public static int commonPrefix(String word) {
        TrieNode curr = head;
        int currentPrefix = 0;

        for(int i = 0; i<word.length(); i++) {
            int ch = word.charAt(i) - '0';

            if(curr.children[ch] == null) {
                break;
            }
            curr = curr.children[ch];
            currentPrefix++;
        }
        return currentPrefix;
    }

    public static int longestCommonPrefix(int[] arr1, int[] arr2) {
        head = new TrieNode(-1);

        for(int num : arr1) {
            String word = String.valueOf(num);
            insertInTrie(word);
        }

        int longestPrefix = Integer.MIN_VALUE;

        for(int num : arr2) {
            String word = String.valueOf(num);
            int commonPrefix = commonPrefix(word);
            longestPrefix = Math.max(longestPrefix, commonPrefix);
        }
        return longestPrefix;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new int[]{1,10,100}, new int[]{1000}));
    }
}
