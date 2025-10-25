package linked_list.medium;

import linked_list.basics.ListNode;

public class Partition {
        public ListNode partition(ListNode head, int x) {
            if (head == null || head.next == null) return head;

            ListNode smallDummy = new ListNode(-1);
            ListNode largeDummy = new ListNode(-1);
            ListNode small = smallDummy;
            ListNode large = largeDummy;

            while (head != null) {
                if (head.val < x) {
                    small.next = head;
                    small = small.next;
                } else {
                    large.next = head;
                    large = large.next;
                }
                head = head.next;
            }

            // terminate the large list
            large.next = null;

            // connect small list with large list
            small.next = largeDummy.next;

            return smallDummy.next;
        }

}
