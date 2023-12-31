
class ListNode {

    int val;
    ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

}

public class AddTwoNumberAsList {

    public static ListNode addTwoNumbers(ListNode list1, ListNode list2) {

        ListNode tlist = new ListNode(-1);
        ListNode pointer = tlist;

        ListNode l1 = list1;
        ListNode l2 = list2;

        int carry = 0;

        while(l1 != null || l2 != null) {

            int sum = 0;
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;

            }
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            carry = sum / 10;
            sum = sum % 10;

            ListNode node = new ListNode(sum);
            pointer.next = node;
            pointer = node;

        }
        if(carry > 0) {
            ListNode carryNode = new ListNode(carry);
            pointer.next = carryNode;
        }
        return tlist.next;

    }

    public static void main(String[] args) {

        ListNode list1 = new ListNode(2);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(3);

        ListNode list2 = new ListNode(5);
        list2.next = new ListNode(6);
        list2.next.next = new ListNode(4);

        ListNode finalList = addTwoNumbers(list1, list2);

        while(finalList != null) {

            System.out.print(finalList.val+" ");
            finalList = finalList.next;

        }


    }

}