package Data_Structure_Algorithms_Topic_Wise_Questions.linked_list;

public class LinkedListCycle {

    public static boolean hasCycle(ListNode head) {

        if(head == null) {
            return false;
        }

        ListNode hare = head;
        ListNode tortoise = head;

        while(hare != null && hare.next != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;

            if(hare == tortoise) {
                return true; // cycle exists
            }
        }
        return false; // cycle does not exist
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

        System.out.println(hasCycle(head));

    }
}
