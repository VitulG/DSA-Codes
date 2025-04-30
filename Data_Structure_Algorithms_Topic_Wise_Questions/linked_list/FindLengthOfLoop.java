package Data_Structure_Algorithms_Topic_Wise_Questions.linked_list;

public class FindLengthOfLoop {

    public static ListNode findLoopNode(ListNode head) {
        ListNode hare = head;
        ListNode tortoise = head;

        while(hare != null && hare.next != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;

            if(hare == tortoise) {
                return tortoise;
            }
        }
        return null;
    }

    public static int countNodesInLoop(ListNode head) {
        if(head == null) {
            return 0;
        }

        ListNode loopNode = findLoopNode(head);

        if(loopNode == null) {
            return 0;
        }

        // I need to count the nodes in the loop
        ListNode nextNode = loopNode.next;
        int count = 1;

        while(nextNode != loopNode) {
            count++;
            nextNode = nextNode.next;
        }

        return count;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(25);
        head.next = new ListNode(14);
        head.next.next = new ListNode(19);
        head.next.next.next = new ListNode(33);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(21);
        head.next.next.next.next.next.next = new ListNode(39);
        head.next.next.next.next.next.next.next = new ListNode(90);
        head.next.next.next.next.next.next.next.next = new ListNode(58);
        head.next.next.next.next.next.next.next.next.next = new ListNode(45);
        head.next.next.next.next.next.next.next.next.next.next = head.next.next.next;

        System.out.println(countNodesInLoop(head));
    }
}
