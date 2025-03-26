package Data_Structure_Algorithms_Topic_Wise_Questions.linked_list;

public class ReverseLinkedListII {

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null) {
            return null;
        }

        ListNode curr = head;
        ListNode prev = null;

        for(int i=1; i<left; i++) {
            prev = curr;
            curr = curr.next;
        }

        ListNode subListHead = curr;
        ListNode subListPrev = null;

        for(int i=1; i <= right - left + 1; i++) {
            ListNode next = subListHead.next;
            subListHead.next = subListPrev;
            subListPrev = subListHead;
            subListHead = next;
        }

        if(prev != null) {
            prev.next = subListPrev;
        }else {
            head = subListHead;
        }
        curr.next = subListHead;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode reversedList = reverseBetween(head, 2, 4);
        System.out.println(reversedList.toString());

    }
}
