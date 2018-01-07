package Leetcode.Review;
/**
 * Created by uslabs on 11/24/17.
 */
public class CopyListWithRandomPointer {

    public static void solution() {
        RandomListNode head = new RandomListNode(-1);
        head.next = new RandomListNode(1);
        head.next.next = new RandomListNode(2);
        head.random = head.next.next;
        RandomListNode copy = copyRandomList(head);
        System.out.println("Done");
    }

    public static RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
        insertBetween(head);
        return getList(head);
    }

    private static void insertBetween(RandomListNode head) {
        if (head == null)
            return;
        RandomListNode node = new RandomListNode(head.label);
        insertBetween(head.next);
        node.next = head.next;
        head.next = node;
    }

    private static RandomListNode getList(RandomListNode head) {
        RandomListNode temp = head, list = head.next;
        while (temp != null) {
            if (temp.random == null)
                temp.next.random = null;
            else
                temp.next.random = temp.random.next;
            temp = temp.next.next;
        }
        temp = head;
        while (temp != null) {
            RandomListNode temp2 = temp.next;
            temp.next = temp2.next;
            if (temp.next == null)
                temp2.next = null;
            else
                temp2.next = temp.next.next;
            temp = temp.next;
        }
        return list;
    }
}

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}
