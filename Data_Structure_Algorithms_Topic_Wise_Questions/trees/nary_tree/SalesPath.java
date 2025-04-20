package Data_Structure_Algorithms_Topic_Wise_Questions.trees.nary_tree;

public class SalesPath {
    static class Node {
        int cost;
        Node[] children;
        Node parent;

        public Node(int cost) {
            this.cost = cost;
        }
    }

    public static int getCheapestCost(Node root) {
        if(root == null) {
            return 0;
        }

        if(root.children == null || root.children.length == 0) {
            return root.cost;
        }

        int minCost = Integer.MAX_VALUE;

        for(Node child : root.children) {
            int childCost = getCheapestCost(child);
            minCost = Math.min(minCost, childCost);
        }
        return minCost + root.cost;
    }

    public static void main(String[] args) {
        Node root = new Node(0);
        Node rootChild1 = new Node(5);
        Node rootChild2 = new Node(3);
        Node rootChild3 = new Node(6);
        root.children = new Node[]{rootChild1, rootChild2, rootChild3};

        Node rootChild1Child1 = new Node(4);
        rootChild1.children = new Node[]{rootChild1Child1};

        Node rootChild2Child1 = new Node(2);
        Node rootChild2Child2 = new Node(0);
        rootChild2.children = new Node[]{rootChild2Child1, rootChild2Child2};

        Node rootChild3Child1 = new Node(1);
        Node rootChild3Child2 = new Node(5);
        rootChild3.children = new Node[]{rootChild3Child1, rootChild3Child2};

        System.out.println(getCheapestCost(root));
    }
}
