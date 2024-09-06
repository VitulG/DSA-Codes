import java.util.HashSet;
import java.util.Set;

public class DeleteNodesFromLinkedListPresentInArray {

    public static ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums) {
            set.add(num);
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        ListNode currentNode = head;

        while(currentNode !=null) {
            if(!set.contains(currentNode.val)) {
                tail.next = currentNode;
                tail = currentNode;
            }
            currentNode = currentNode.next;
        }
        tail.next = null;
        return dummy.next;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(10);
        head.next.next = new ListNode(9);

        int[] nums = {9,5,2};

        ListNode currentNode = modifiedList(nums, head);

        while(currentNode != null) {
            System.out.print(currentNode.val + " ");
            currentNode = currentNode.next;
        }
    }
}
