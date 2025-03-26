package Data_Structure_Algorithms_Topic_Wise_Questions.linked_list;

public class OddEvenLinkedList {

    public static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode oddPointer = head;
        ListNode evenPointer = head.next;
        ListNode evenHead = head.next;

        while(evenPointer != null && evenPointer.next != null) {
            oddPointer.next = evenPointer.next;
            evenPointer.next = evenPointer.next.next;

            oddPointer = oddPointer.next;
            evenPointer = evenPointer.next;
        }
        oddPointer.next = evenHead;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(oddEvenList(head));
    }
}
