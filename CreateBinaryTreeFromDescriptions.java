import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CreateBinaryTreeFromDescriptions {

    public static TreeNode createBinaryTree(int[][] descriptions) {
        if( descriptions == null || descriptions.length <= 0) {
            return null;
        }

        Map<Integer, TreeNode> map = new HashMap<Integer, TreeNode>();
        Set<Integer> childs = new HashSet<Integer>();

        for(int[] desc : descriptions) {
            int parent = desc[0];
            int child = desc[1];
            int isLeft = desc[2];

            if(!map.containsKey(parent)) {
                map.put(parent, new TreeNode(parent));
            }

            if(!map.containsKey(child)) {
                map.put(child, new TreeNode(child));
            }

            if(isLeft == 1) {
                map.get(parent).left = map.get(child);
            }else {
                map.get(parent).right = map.get(child);
            }
            childs.add(child);
        }

        for(int[] desc : descriptions) {
            int parent = desc[0];
            if(!childs.contains(parent)) {
                return map.get(parent);
            }
        }
        return null;
    } 

    public static void main(String[] args) {
        
    }
    
}
