package Data_Structure_Algorithms_Topic_Wise_Questions.linked_list;

public class DeleteTheMiddleNodeOfALinkedList {

    public static ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }

        ListNode prev = null;
        ListNode hare = head;
        ListNode tortoise = head;

        while(hare != null && hare.next != null) {
            prev = tortoise;
            tortoise = tortoise.next;
            hare = hare.next.next;
        }

        prev.next = prev.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(6);

        ListNode updatedList = deleteMiddle(head);

        while(updatedList != null) {
            System.out.print(updatedList.val+" ");
            updatedList = updatedList.next;
        }
    }
}
