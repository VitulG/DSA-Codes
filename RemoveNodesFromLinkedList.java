import java.util.Stack;

public class RemoveNodesFromLinkedList {

    public static ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static ListNode removeNodes(ListNode head) {
        if(head == null) {
            return null;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode curr = head;

        stack.push(curr);

        while(curr.next != null) {
            while(!stack.isEmpty() && stack.peek().val < curr.next.val) {
                stack.pop();
            }
            stack.push(curr.next);
            curr = curr.next;
        }
        stack.push(curr);

        ListNode updatedList = new ListNode(-1);
        ListNode tail = updatedList;
        while(!stack.isEmpty()) {
            tail.next = stack.pop();
            tail = tail.next;
        }
        tail.next = null;
        return reverseList(updatedList.next);
        
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(1);
        //head.next.next.next.next = new ListNode(8);
        ListNode ans = removeNodes(head);
        ListNode curr = ans;

        while(curr != null) {
            System.out.print(curr.val+" ");
            curr = curr.next;
        }
    }
}