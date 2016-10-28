import java.util.List;

/**
 * Created by techmint on 10/22/16.
 */
public class RemoveDuplicatesFromSortedList {
    public static ListNodeA deleteDuplicates(ListNodeA head) {
        ListNodeA curr = head;
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

    public static void printList(ListNodeA head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

class ListNodeA {
    int val;
    ListNodeA next;

    ListNodeA(int a) {
        this.val = a;
    }
}
