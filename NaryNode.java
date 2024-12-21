import java.util.List;

public class NaryNode {
    int val;
    List<NaryNode> children;

    public NaryNode() { }

    public NaryNode(int val) {
        this.val = val;
    }

    public NaryNode(int val, List<NaryNode> children) {
        this.val = val;
        this.children = children;
    }
}