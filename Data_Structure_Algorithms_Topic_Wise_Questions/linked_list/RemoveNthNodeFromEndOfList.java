package Data_Structure_Algorithms_Topic_Wise_Questions.linked_list;

public class RemoveNthNodeFromEndOfList {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return null;
        }

        int totalNodes = 0;
        ListNode curr = head;

        while(curr != null) {
            totalNodes++;
            curr = curr.next;
        }

        int nodeToBeRemoved = totalNodes - n;

        if(nodeToBeRemoved == 0) {
            return head.next;
        }

        curr = head;
        while(curr != null && nodeToBeRemoved-- > 1) {
            curr = curr.next;
        }
        curr.next = curr.next.next;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        System.out.println(removeNthFromEnd(head, 1));
    }
}
