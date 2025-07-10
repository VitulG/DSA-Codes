package Data_Structure_Algorithms_Topic_Wise_Questions.trie;

public class FindTheLongestString {

    /*
        Approach 1: Brute Force
        ------------------------
                1. For each word in the array, check if all its prefixes are present in the array.
                2. This can be done using a HashSet for fast prefix lookup.
                3. Keep track of the longest such word.
                    - If multiple words have the same length, return the lexicographically smallest one.

                Time Complexity: O(n * k)
                - Where n = number of words, k = average length of word
                Space Complexity: O(n)
                - Due to storing all words in a HashSet

        ------------------------------------------------------

        Approach 2: Trie-Based (Optimized)
        -----------------------------------
                1. Insert all words into a Trie. Mark the end of each word with a flag (e.g., isCompleted = true).
                2. For each word, check if all its prefixes exist in the Trie and are complete words.
                3. If valid, compare with the current longest word:
                            - Update if the current word is longer
                   - Or if same length but lexicographically smaller

            Time Complexity: O(n * k)
            - For inserting words and checking prefixes
            Space Complexity: O(n * k)
            - Trie size in worst case
     */

    private static final TrieNode root = new TrieNode('~');

    public static void insertInTrie(String word) {
        TrieNode curr = root;

        for(char ch : word.toCharArray()) {
            int idx = ch -'a';

            if(curr.children[idx] == null) {
                curr.children[idx] = new TrieNode(ch);
            }
            curr = curr.children[idx];
        }
        curr.isCompleted = true;
    }

    public static boolean isValidPrefixWord(String word) {
        TrieNode curr = root;

        for(char ch : word.toCharArray()) {
            int idx = ch - 'a';

            if(curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];

            if(!curr.isCompleted) {
                return false;
            }
        }
        return true;
    }

    public static String longestString(String[] words) {
        // code here
        if(words.length == 0) {
            return "";
        }

        for(String word : words) {
            insertInTrie(word);
        }

        String longestString = "";

        for(String word : words) {
            if(isValidPrefixWord(word)) {
                if(longestString.length() < word.length()) {
                    longestString = word;
                }else if(longestString.length() == word.length()) {
                    longestString = (longestString.compareTo(word) > 0) ? word : longestString;
                }
            }
        }
        return longestString;
    }

    public static void main(String[] args) {
        System.out.println(longestString(new String[]{"ab", "a", "abc", "abd"}));
    }
}
