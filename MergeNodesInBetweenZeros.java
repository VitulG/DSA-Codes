public class MergeNodesInBetweenZeros {

    public static ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(-1);
        int sum = 0;
        
        ListNode curr = head;
        ListNode tail = dummy;

        while(curr != null) {
            if(curr.val == 0 && sum != 0) {
                tail.next = new ListNode(sum);
                tail = tail.next;
                sum = 0;
            }
            sum += curr.val;
            curr = curr.next;
        }

        if(sum != 0) {
            tail.next = new ListNode(sum);
            tail = tail.next;
        }

        return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(0);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next.next.next.next = new ListNode(5);

        ListNode result = mergeNodes(head);
        ListNode curr = result;

        while(curr != null) {
            System.out.print(curr.val+" ");
            curr = curr.next;
        }
    }
}
