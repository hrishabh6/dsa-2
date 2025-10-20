package linked_list.medium;

import linked_list.basics.ListNode;

public class LoopInLL2 {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        if (head == null || head.next == null) return null;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            };
        }
        return null;
    }

}
