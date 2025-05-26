package Data_Structure_Algorithms_Topic_Wise_Questions.linked_list;

public class InsertInSortedCircularLinkedList {

    /*
        Approach: - Since the Linked List is sorted and circular, so we need to keep track of the next grater node from the current
                        node. if the head is <= data, we have to insert a node there or else we need to insert in
                        the somewhere in the list.

                    TC -> O(n)
                    SC -> O(1)
     */

    public static ListNode sortedInsert(ListNode head, int data) {
        // code here
        ListNode curr = head;

        if(head.val >=  data) {
            while(curr.next != head) {
                curr = curr.next;
            }
            ListNode newHead = new ListNode(data);
            curr.next = newHead;
            newHead.next = head;
            return newHead;
        }else {
            while(curr.next != head && data > curr.next.val) {
                curr = curr.next;
            }
            ListNode newNode = new ListNode(data);
            newNode.next = curr.next;
            curr.next = newNode;
            return head;
        }
    }

    public static void main(String[] args) {

    }
}
