package Data_Structure_Algorithms_Topic_Wise_Questions.graph;

import java.util.*;

public class CloneGraph {

    static class Node {
        public int val;
        public List<Node> neighbours;

        public Node() {}

        public Node(int _val) {
            val = _val;
            neighbours = new ArrayList<Node>();
        }

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbours = _neighbors;
        }
    }

    public static Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node clonedNode = new Node(node.val);

        map.put(node, clonedNode);

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(node);

        while(!queue.isEmpty()) {
            Node currentNode = queue.poll();

            for(Node originalNbr : currentNode.neighbours) {
                if(!map.containsKey(originalNbr)) {
                    Node clonedNbr = new Node(originalNbr.val);
                    map.put(originalNbr, clonedNbr);
                    map.get(currentNode).neighbours.add(clonedNbr);
                    queue.offer(originalNbr);
                }else {
                    map.get(currentNode).neighbours.add(map.get(originalNbr));
                }
            }

        }
        return map.get(node);
    }

    public static void main(String[] args) {


    }
}
