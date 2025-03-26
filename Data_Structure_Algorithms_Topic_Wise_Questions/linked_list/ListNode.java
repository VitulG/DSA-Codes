package Data_Structure_Algorithms_Topic_Wise_Questions.linked_list;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        ListNode curr = this;  // Start from current node
        while (curr != null) {
            sb.append(curr.val);
            if (curr.next != null) {
                sb.append(", ");
            }
            curr = curr.next;
        }

        sb.append("]");
        return sb.toString(); // Return the final string representation
    }
}
