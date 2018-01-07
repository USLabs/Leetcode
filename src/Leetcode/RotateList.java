package Leetcode;

import Leetcode.Utils.ListNode;

/**
 * Created by uslabs on 10/15/17.
 */
public class RotateList {
    public static void solution() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
//        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(4);
//        node.next.next.next.next = new ListNode(5);
        rotateRight(node, 2);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (k == 0)
            return head;
        if (head == null || head.next == null)
            return head;

        int count = getLength(head);

        if (k >= count)
            k = k % count;

        if (k == 0)
            return head;

        if (count == 0)
            return head;

        ListNode curr = head;
        for (int i = 0; i < count - k - 1; i++) {
            curr = curr.next;
        }

        ListNode a = curr.next;
        curr.next = null;
        curr = a;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = head;
        return a;
    }

    public static int getLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}