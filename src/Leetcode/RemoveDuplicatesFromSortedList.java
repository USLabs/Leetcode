package Leetcode;

import Leetcode.Utils.ListNode;

/**
 * Created by techmint on 10/22/16.
 */
public class RemoveDuplicatesFromSortedList {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        if (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr = curr.next;
                return deleteDuplicates(curr);
            } else
            {
                curr.next = deleteDuplicates(curr.next);
                return curr;
            }
        } else
            return head;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}