package Data_Structure_Algorithms_Topic_Wise_Questions.trie;

public class TrieBitNode {
    int bit;
    TrieBitNode[] children;

    public TrieBitNode(int bit) {
        this.bit = bit;
        children = new TrieBitNode[2];
    }
}
