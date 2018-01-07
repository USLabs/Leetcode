package Leetcode;

/**
 * Created by uslabs on 10/29/17.
 */
public class RemoveNthNodeFromEndOfList {
    public static void solution() {
        ListNode node = new ListNode(1);
        //node.next = new ListNode(2);
        //node.next.next = new ListNode(3);
        //node.next.next.next = new ListNode(4);
        //node.next.next.next.next = new ListNode(5);

        node = removeNthFromEnd(null, 2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)
            return head;

        ListNode p1 = head, p2 = head, prev = head;
        while (n > 1) {
            p1 = p1.next;
            n--;
        }

        while (p1.next != null) {
            prev = p2;
            p1 = p1.next;
            p2 = p2.next;
        }

        if (p2 == head)
            return p2.next;
        else {
            prev.next = p2.next;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}