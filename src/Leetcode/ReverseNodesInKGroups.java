package Leetcode;
import Leetcode.Utils.ListNode;

public class ReverseNodesInKGroups {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;
        int count = 0;

        while (current != null && count < k) {
            count++;
            current = current.next;
        }

        if (count < k)
            return head;
        else {
            count = 0;
            current = head;
        }
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if (current != null)
            head.next = reverseKGroup(current, k);

        return prev;
    }
}
