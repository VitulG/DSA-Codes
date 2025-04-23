package Data_Structure_Algorithms_Topic_Wise_Questions.trie;

public class LongestCommonPrefix {
    private static final TrieNode root = new TrieNode('~');

    public static void insertInTrie(String word) {
        TrieNode curr = root;

        for(char ch : word.toCharArray()) {
            if(curr.children[ch-'a'] == null) {
                curr.children[ch-'a'] = new TrieNode(ch);
            }
            curr = curr.children[ch-'a'];
        }
        curr.isCompleted = true;
    }

    public static String getLongestCommonPrefix(String word) {
        TrieNode curr = root;
        StringBuilder prefix = new StringBuilder();

        for(char ch : word.toCharArray()) {
            if(curr.children[ch-'a'] != null) {
                int child = 0;
                for(int i=0; i<curr.children.length; i++) {
                    if(curr.children[i] != null) {
                        child++;
                    }
                }

                if(child > 1 || curr.isCompleted) {
                    break;
                }else {
                    prefix.append(ch);
                    curr = curr.children[ch-'a'];
                }
            }else {
                break;
            }
        }
        return prefix.toString();
    }

    public static String longestCommonPrefix(String[] strs) {
        // Approach 1. using Brute Force take one string and compare with other string so we can get a prefix
        // TC -> O(n*m) SC -> O(1)

        // Approach 2. using Sorting, we can sort the words in ascending order and just check the first and last word of the string
        // TC -> O(n log n) SC -> O(1)

        // Approach 3. using Trie insert into the trie every word and just check every level if they contain only one character only.
        // TC -> O(n) SC -> O(1)

        if(strs.length == 1) {
            return strs[0];
        }

        // Step 1. insert into the trie
        for(String word : strs) {
            insertInTrie(word);
        }

        return getLongestCommonPrefix(strs[0]);
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"ab","a"}));
    }
}
