public class SumOfPrefixScoresOfStrings {
    static class TrieNode {
        TrieNode[] childrens;
        int prefixCount;

        public TrieNode() {
            childrens = new TrieNode[26];
            prefixCount = 0;
        }
    }

    private static final TrieNode head = new TrieNode();  // Initialize the root of Trie

    public static void insert(String word) {
        TrieNode curr = head;

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            curr.prefixCount++;  // Count each node as part of a prefix
            if (curr.childrens[idx] == null) {
                curr.childrens[idx] = new TrieNode();
            }
            curr = curr.childrens[idx];
        }
        curr.prefixCount++;  // Final character node as part of the prefix
    }

    public static int calculatePrefixScore(String word) {
        TrieNode curr = head;
        int sum = 0;

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (curr.childrens[idx] == null) {
                break;  // If a prefix doesn't exist, exit early
            }
            curr = curr.childrens[idx];
            sum += curr.prefixCount;  // Sum up the prefix counts
        }

        return sum;
    }

    public static int[] sumPrefixScores(String[] words) {
        // Insert all words into the Trie
        for (String word : words) {
            insert(word);
        }

        // Calculate prefix scores for each word
        int[] result = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            result[i] = calculatePrefixScore(words[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] result = sumPrefixScores(new String[]{"v","vi","vit","vitu","vitul"});

        for(int score : result) {
            System.out.print(score+" ");
        }
    }
}
