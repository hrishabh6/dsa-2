package linked_list.medium;

import linked_list.basics.ListNode;

public class RemoveDuplicates2 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode curr = new ListNode(-1);
        curr.next = head;
        ListNode dummy = curr;

        while (curr.next != null && curr.next.next != null) {
            ListNode temp = curr.next;

            if (temp.val != temp.next.val) {
                curr = curr.next;
            } else {
                // skip all nodes with same value
                while (temp.next != null && temp.val == temp.next.val) {
                    temp = temp.next;
                }
                curr.next = temp.next;
            }
        }

        return dummy.next;
    }


}
