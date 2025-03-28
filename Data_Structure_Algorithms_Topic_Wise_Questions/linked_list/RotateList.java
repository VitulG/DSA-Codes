package Data_Structure_Algorithms_Topic_Wise_Questions.linked_list;

public class RotateList {

    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) {
            return head;
        }

        int totalNodes = 1;
        ListNode curr = head;

        while(curr.next != null) {
            totalNodes++;
            curr = curr.next;
        }


        k = k%totalNodes;

        if(k == 0) {
            return head;
        }

        ListNode tail = head;

        for(int i=1; i<totalNodes-k; i++) {
            tail = tail.next;
        }

        ListNode newHead = tail.next;
        tail.next = null;
        curr.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println(rotateRight(head, 2));
    }
}
