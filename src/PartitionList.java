public class PartitionList {
    public static ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        ListNode right = null, left = null, curr = head, temp = null, headleft = null, headright = null;
        while (curr != null) {
            if (curr.val < x) {
                if (left == null) {
                    left = curr;
                    headleft = left;
                } else {
                    left.next = curr;
                    left = curr;
                }
            } else {
                if (right == null) {
                    right = curr;
                    headright = right;
                } else {
                    right.next = curr;
                    right = curr;
                }
            }
            curr = curr.next;
        }
        if (left != null) {
            if (headright != null) {
                left.next = headright;
                right.next = null;
                return headleft;
            } else {
                return headleft;
            }
        } else {
            return headright;
        }
    }
}