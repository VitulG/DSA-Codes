
import java.util.ArrayList;
import java.util.List;

public class NaryTreePostorderTraversal {

    public static void naryPostorderTraversal(NaryNode node, List<Integer> ans) {
        if(node == null) {
            return;
        }

        for(NaryNode child : node.children) {
            naryPostorderTraversal(child, ans);
        }
        ans.add(node.val);
    }

    public static List<Integer> postorder(NaryNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        List<Integer> ans = new ArrayList<>();
        naryPostorderTraversal(root, ans);

        return ans;
    }

    public static void main(String[] args) {
        NaryNode root = new NaryNode(1);
        NaryNode node1 = new NaryNode(2);
        NaryNode node2 = new NaryNode(3);
        NaryNode node3 = new NaryNode(4);

        root.children.add(node1);
        root.children.add(node2);
        root.children.add(node3);

        NaryNode node4 = new NaryNode(5);
        NaryNode node5 = new NaryNode(6);

        node2.children.add(node4);
        node2.children.add(node5);

        System.out.println(postorder(root));
    
    }    
}
