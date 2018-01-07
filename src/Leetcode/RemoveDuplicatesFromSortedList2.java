package Leetcode;

import Leetcode.Utils.ListNode;

/**
 * Created by techmint on 10/22/16.
 */
public class RemoveDuplicatesFromSortedList2 {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        if (head.val == head.next.val)
            return deleteDuplicatesUtil(head.next, head.val);
        else {
            head.next = deleteDuplicatesUtil(head.next, head.val);
            return head;
        }
    }

    public static ListNode deleteDuplicatesUtil(ListNode head, int prev) {
        if (head == null)
            return head;
        ListNode curr = head;
        if (curr.val == prev)
            return deleteDuplicatesUtil(curr.next, curr.val);
        else {
            if (curr.next == null)
                return curr;
            else {
                if (curr.val == curr.next.val) {
                    return deleteDuplicatesUtil(curr.next, curr.val);

                } else {
                    curr.next = deleteDuplicatesUtil(curr.next, curr.val);
                    return curr;
                }
            }
        }
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}