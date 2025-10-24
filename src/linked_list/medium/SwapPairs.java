package linked_list.medium;

import linked_list.basics.ListNode;

public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        // Base case: if 0 or 1 node, return as is
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (head != null && head.next != null) {
            // Nodes to be swapped
            ListNode first = head;
            ListNode second = head.next;

            // Swapping
            prev.next = second;
            first.next = second.next;
            second.next = first;

            // Move pointers forward
            prev = first;
            head = first.next;
        }

        return dummy.next;
    }


}
