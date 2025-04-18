package Data_Structure_Algorithms_Topic_Wise_Questions.trie;

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode('~');
    }

    public void insert(String word) {
        TrieNode curr = root;

        for(char ch : word.toCharArray()) {
            if(curr.children[ch-'a'] == null) {
                curr.children[ch-'a'] = new TrieNode(ch);
            }
            curr = curr.children[ch-'a'];
        }
        curr.isCompleted = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()) {
            if(curr.children[ch-'a'] == null) {
                return false;
            }
            curr = curr.children[ch-'a'];
        }
        return curr.isCompleted;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char ch : prefix.toCharArray()) {
            if(curr.children[ch-'a'] == null) {
                return false;
            }
            curr = curr.children[ch-'a'];
        }
        return true;
    }
}


public class ImplementTrie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}
