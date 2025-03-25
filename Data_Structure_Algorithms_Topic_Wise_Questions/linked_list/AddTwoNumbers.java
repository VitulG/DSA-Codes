package Data_Structure_Algorithms_Topic_Wise_Questions.linked_list;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode tail = dummyNode;

        ListNode l1Pointer = l1;
        ListNode l2Pointer = l2;

        int carry = 0;

        while(l1Pointer != null || l2Pointer != null) {
            int sum = 0;

            if(l1Pointer != null) {
                sum += l1Pointer.val;
                l1Pointer = l1Pointer.next;
            }

            if(l2Pointer != null) {
                sum += l2Pointer.val;
                l2Pointer = l2Pointer.next;
            }

            sum += carry;
            carry = sum / 10;
            sum = sum % 10;

            ListNode newNode = new ListNode(sum);
            tail.next = newNode;
            tail = newNode;
        }

        if(carry > 0) {
            tail.next = new ListNode(carry);
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode sum = addTwoNumbers(l1, l2);
        ListNode curr = sum;

        while(curr != null) {
            System.out.print(curr.val+" ");
            curr = curr.next;
        }

    }
}
