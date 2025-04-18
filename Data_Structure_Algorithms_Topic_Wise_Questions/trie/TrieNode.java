package Data_Structure_Algorithms_Topic_Wise_Questions.trie;

public class TrieNode {
    char val;
    TrieNode[] children;
    boolean isCompleted;

    public TrieNode(char val) {
        children = new TrieNode[26];
        this.val = val;
        isCompleted = false;
    }
}
