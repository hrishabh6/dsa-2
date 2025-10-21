package linked_list.medium;

import linked_list.basics.ListNode;

public class NthNode {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head == null || head.next == null) return null;

        ListNode fast = head, slow = head;
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }
        if(fast == null){
            return head.next;
        }

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }

}
