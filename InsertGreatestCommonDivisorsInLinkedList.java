public class InsertGreatestCommonDivisorsInLinkedList {

    public static int findGcd(int first, int second) {
        if (second == 0) {
            return first;
        }
        return findGcd(second, first % second);
    }

    public static ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode prev = head;
        ListNode curr = head.next;

        while(curr != null) {
            int gcd = findGcd(prev.val, curr.val);
            ListNode newNode = new ListNode(gcd);
            prev.next = newNode;
            newNode.next = curr;
            prev = prev.next.next;
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(18);
        head.next = new ListNode(6);
        head.next.next = new ListNode(10);
        head.next.next.next = new ListNode(3);

        ListNode result = insertGreatestCommonDivisors(head);
        ListNode curr = result;

        while(curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}
